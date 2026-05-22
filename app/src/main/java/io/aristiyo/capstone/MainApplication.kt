package io.aristiyo.capstone

import android.app.Application
import com.aheaditec.talsec_security.security.api.SuspiciousAppInfo
import com.aheaditec.talsec_security.security.api.Talsec
import com.aheaditec.talsec_security.security.api.TalsecConfig
import com.aheaditec.talsec_security.security.api.TalsecMode
import com.aheaditec.talsec_security.security.api.ThreatListener
import dagger.hilt.android.HiltAndroidApp
import io.aristiyo.core.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        val config = TalsecConfig.Builder(
            EXPECTED_PACKAGE_NAME,
            EXPECTED_SIGNING_CERTIFICATE_HASH_BASE64
        )
            .watcherMail(WATCHER_MAIL)
            .prod(IS_PROD)
            .killOnBypass(KILL_ON_BYPASS)
            .build()

        ThreatListener(threatDetectedListener).registerListener(this)
        Talsec.start(this, config, TalsecMode.BACKGROUND)
    }


    val threatDetectedListener = object : ThreatListener.ThreatDetected() {

        override fun onRootDetected() {
            Timber.w("onRootDetected")
        }

        override fun onDebuggerDetected() {
            Timber.w("onDebuggerDetected")
        }

        override fun onEmulatorDetected() {
            Timber.w("onEmulatorDetected")
        }

        override fun onTamperDetected() {
            Timber.w("onTamperDetected")
        }

        override fun onUntrustedInstallationSourceDetected() {
            Timber.w("onUntrustedInstallationSourceDetected")
        }

        override fun onHookDetected() {
            Timber.w("onHookDetected")
        }

        override fun onDeviceBindingDetected() {
            Timber.w("onDeviceBindingDetected")
        }

        override fun onObfuscationIssuesDetected() {
            Timber.w("onObfuscationIssueDetected")
        }

        override fun onScreenshotDetected() {
            Timber.w("onScreenshotDetected")
        }

        override fun onScreenRecordingDetected() {
            Timber.w("onScreenRecordingDetected")
        }

        override fun onMultiInstanceDetected() {
            Timber.w("onMultiInstanceDetected")
        }

        override fun onUnsecureWifiDetected() {
            Timber.w("onUnsecureWifiDetected")
        }

        override fun onTimeSpoofingDetected() {
            Timber.w("onTimeSpoofingDetected")
        }

        override fun onLocationSpoofingDetected() {
            Timber.w("onLocationSpoofingDetected")
        }

        override fun onAutomationDetected() {
            Timber.w("onAutomationDetected")
        }

        override fun onMalwareDetected(suspiciousApps: List<SuspiciousAppInfo>) {
            Timber.w("onMalwareDetected")
        }
    }

    private companion object {
        private const val EXPECTED_PACKAGE_NAME = "io.aristiyo.capstone"
        private val EXPECTED_SIGNING_CERTIFICATE_HASH_BASE64 = arrayOf(
            "mVr/qQLO8DKTwqlL+B1qigl9NoBnbiUs8b4c2Ewcz0k="
        )
        private const val WATCHER_MAIL = "aristhiooo@gmail.com"
        private const val IS_PROD = true
        private const val KILL_ON_BYPASS = true
    }
}
