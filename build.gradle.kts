// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.dynamic.feature) apply false
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.dagger.hilt) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.kover) apply false
    alias(libs.plugins.owasp.depcheck)
}

dependencyCheck {
    failBuildOnCVSS = 7.0f
    formats = listOf("HTML", "XML")
    suppressionFile = "owasp-suppressions.xml"
    nvd {
        apiKey = System.getenv("NVD_API_KEY") ?: ""
        delay = 3500
    }
    analyzers {
        assemblyEnabled = false
        nuspecEnabled = false
        nugetconfEnabled = false
        pyDistributionEnabled = false
        pyPackageEnabled = false
        rubygemsEnabled = false
        cmakeEnabled = false
        autoconfEnabled = false
        composerEnabled = false
        cocoapodsEnabled = false
        swiftEnabled = false
        bundleAuditEnabled = false
    }
}