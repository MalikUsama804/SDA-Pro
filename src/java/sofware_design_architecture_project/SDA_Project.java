package com.mycompany.sda_project;

import com.mycompany.sda_project.controller.IncidentController;
import com.mycompany.sda_project.model.CanonicalAlert;
import com.mycompany.sda_project.model.AlertCampaign;
import com.mycompany.sda_project.model.IncidentModel;
import com.mycompany.sda_project.view.IncidentDashboardView;
import com.mycompany.sda_project.patterns.*;
import java.util.HashMap;
import java.util.Map;

public class SDA_Project {

    public static void main(String[] args) {
        System.out.println("=== SDA-Pro Complete Baseline Test ===");

        // 1. Setup raw input alert datasets
        IngestionConfigManager.getInstance().setSourceStatus("firewall", true);

        Map<String, String> rawSplunkData = new HashMap<>();
        rawSplunkData.put("id", "SPLK-9921");
        rawSplunkData.put("source_ip", "192.168.1.50");
        rawSplunkData.put("lvl", "CRITICAL");
        rawSplunkData.put("msg", "Brute force attempt detected");
        CanonicalAlert alert1 = AlertNormalizerFactory.createNormalizer("splunk").normalize(rawSplunkData);

        Map<String, String> rawFirewallData = new HashMap<>();
        rawFirewallData.put("event_id", "FW-004");
        rawFirewallData.put("src_ip", "192.168.1.50");
        rawFirewallData.put("priority", "HIGH");
        rawFirewallData.put("action", "DROP");
        CanonicalAlert alert2 = AlertNormalizerFactory.createNormalizer("firewall").normalize(rawFirewallData);

        // 2. Composite Campaign Structure
        AlertCampaign ransomwareCampaign = new AlertCampaign("Ransomware Attack Target-50");
        ransomwareCampaign.addAlert(alert1);
        ransomwareCampaign.addAlert(alert2);

        // 2.5 Testing Abstract Factory Pattern: Generating Enrichment Context Data
        System.out.println("\n--- 1.25 Generating Context via Enrichment Provider Factory ---");
        EnrichmentProviderFactory enrichFactory = new StandardEnrichmentFactory();
        GeoProvider geoTool = enrichFactory.createGeoProvider();
        AssetProvider assetTool = enrichFactory.createAssetProvider();
        
        System.out.println("  [Enrichment Result] " + geoTool.getGeoLocation(alert1.getIpAddress()));
        System.out.println("  [Enrichment Result] " + assetTool.getAssetCriticality(alert1.getIpAddress()));

        // 3. Testing Chain of Responsibility: Build the 4-Handler Processing Pipeline
        System.out.println("\n--- 1.5 Executing Processing Pipeline ---");
        EnrichmentHandler pipelineStart = new DeduplicationHandler(); // Step 1
        EnrichmentHandler pipelineSecond = new LogHandler();          // Step 2
        EnrichmentHandler pipelineThird = new SeverityFilterHandler(); // Step 3
        EnrichmentHandler pipelineFourth = new RoutingHandler();       // Step 4

        // Connect the 4 links together cleanly according to the blueprint layout
        pipelineStart.setNext(pipelineSecond);
        pipelineSecond.setNext(pipelineThird);
        pipelineThird.setNext(pipelineFourth);

        // Run the entire chain
        pipelineStart.process(ransomwareCampaign);

        // 4. Incident Backend Facade Processing Logic Loop
        System.out.println("\n--- 2. Triggering Incident Response Facade ---");
        
        // Simulating the Proxy check step right before executing our main response orchestration scripts
        ThreatIntelProxy intelProxy = new ThreatIntelProxy();
        int verifiedScore = intelProxy.getThreatScoreWithProxyCheck(alert1.getIpAddress(), "SECURE_SDA_KEY_2026");
        System.out.println("[Main Security Context] Verified proxy threat assessment score result: " + verifiedScore + "/100");

        IncidentResponseFacade systemFacade = new IncidentResponseFacade();
        systemFacade.orchestrateResponse("INC-2026-TXT", ransomwareCampaign, alert1.getIpAddress());

        // 5. Abstract Factory Notifications
        System.out.println("--- 3. Triggering Abstract Notification Factory ---");
        NotificationFactory generalFactory = new StandardNotificationFactory();
        generalFactory.createEmailNotifier().sendEmail("CRITICAL incident INC-2026-TXT requires immediate Tier-3 evaluation.");
        generalFactory.createSlackNotifier().sendSlackMessage("⚠️ ALERT: IP 192.168.1.50 block command verified on Firewall.");

        // 6. Observer Messaging Bus Updates
        System.out.println("\n--- 4. Registering Observers & Publishing Events ---");
        SecurityEventBus eventBus = SecurityEventBus.getInstance();
        eventBus.subscribe(new DashboardUpdater());
        eventBus.subscribe(new AuditLogger());
        System.out.println("Broadcasting: IncidentStateChanged Event...");
        eventBus.publishEvent("IncidentStateChanged", "Incident INC-2026-TXT state moved to CLOSED.");

        // 7. Testing MVC Architecture Component Layout Rendering
        System.out.println("\n--- 5. Simulating Frontend Dashboard View Rendering (MVC) ---");
        IncidentModel model = new IncidentModel("INC-2026-TXT", "ACTIVE_TRIAGE");
        IncidentDashboardView view = new IncidentDashboardView();
        IncidentController controller = new IncidentController(model, view);

        // Render initial view layout content fields safely
        controller.refreshDashboard();

        // Update model properties contextually via the controller class layer
        System.out.println("Controller updating model data status payload to SECURE...");
        controller.updateIncidentStatus("CLOSED & SECURE");
        controller.refreshDashboard();
        // 8. Execute Automated Pattern Quality Validation Test Suite
        SDA_Architecture_TestSuite.runAutomationTests();
    }
}