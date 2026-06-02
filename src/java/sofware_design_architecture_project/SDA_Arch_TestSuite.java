package com.mycompany.sda_project;

import com.mycompany.sda_project.patterns.IngestionConfigManager;
import com.mycompany.sda_project.patterns.ThreatIntelProxy;
import com.mycompany.sda_project.service.IncidentContext;

public class SDA_Architecture_TestSuite {

    public static void runAutomationTests() {
        System.out.println("\n==================================================");
        System.out.println("   🚀 RUNNING AUTOMATED PATTERN VALIDATION SUITE   ");
        System.out.println("==================================================");

        int passedTests = 0;

        // Test 1: Verify Ingestion Configuration Manager (Singleton Pattern)
        try {
            System.out.print("[TEST 1] Verifying Singleton Ingestion Manager... ");
            IngestionConfigManager instance1 = IngestionConfigManager.getInstance();
            IngestionConfigManager instance2 = IngestionConfigManager.getInstance();
            
            if (instance1 == instance2) {
                System.out.println("✅ PASSED (Identical Memory References Verified)");
                passedTests++;
            } else {
                System.out.println("❌ FAILED");
            }
        } catch (Exception e) { System.out.println("❌ EXCEPTION: " + e.getMessage()); }

        // Test 2: Verify Gateway Rate-Limiting Protection (Proxy Pattern)
        try {
            System.out.print("[TEST 2] Verifying Threat Intel Proxy Throttling... ");
            ThreatIntelProxy testProxy = new ThreatIntelProxy();
            
            // Fire off a rapid succession of requests to deliberately trigger the proxy guard
            testProxy.getThreatScoreWithProxyCheck("10.0.0.1", "SECURE_SDA_KEY_2026");
            testProxy.getThreatScoreWithProxyCheck("10.0.0.1", "SECURE_SDA_KEY_2026");
            testProxy.getThreatScoreWithProxyCheck("10.0.0.1", "SECURE_SDA_KEY_2026");
            int throttledScore = testProxy.getThreatScoreWithProxyCheck("10.0.0.1", "SECURE_SDA_KEY_2026");

            if (throttledScore == 45) { // Our built-in protection fallback score
                System.out.println("✅ PASSED (429 Flood Attack Successfully Throttled)");
                passedTests++;
            } else {
                System.out.println("❌ FAILED");
            }
        } catch (Exception e) { System.out.println("❌ EXCEPTION: " + e.getMessage()); }

        // Test 3: Verify Root Context State Lifecycle Bounds (State Pattern)
        try {
            System.out.print("[TEST 3] Verifying Initial State Machine Default... ");
            IncidentContext ctx = new IncidentContext("INC-TEST-99");
            
            if ("NEW".equals(ctx.getCurrentState().getStateName())) {
                System.out.println("✅ PASSED (Context successfully bounds to NEW State)");
                passedTests++;
            } else {
                System.out.println("❌ FAILED");
            }
        } catch (Exception e) { System.out.println("❌ EXCEPTION: " + e.getMessage()); }

        System.out.println("==================================================");
        System.out.println("🏆 VERIFICATION COMPLETE: (" + passedTests + "/3) PATTERN METRICS SECURED!");
        System.out.println("==================================================\n");
    }
}