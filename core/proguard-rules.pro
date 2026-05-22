# ── SQLCipher & SQLite Rules ──────────────────────────────────────────────────
-keep class net.zetetic.database.sqlcipher.** { *; }
-keep class net.zetetic.database.** { *; }
-dontwarn net.zetetic.database.sqlcipher.**
-keep class androidx.sqlite.db.** { *; }

# ── Room Runtime & Data Layer ─────────────────────────────────────────────────
-keep class androidx.room.RoomDatabase { *; }
-keep class * extends androidx.room.RoomDatabase
-dontwarn androidx.room.**
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao class * { *; }

# ── Hilt Dependency Injection (Crucial for Multi-Module Bridge) ───────────────
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod
-keep class io.aristiyo.core.di.** { *; }
-keep class *__HiltComponents_* { *; }
-keep class * extends java.lang.annotation.Annotation { *; }
-keep @dagger.Module class * { *; }
-keepclassmembers class * {
    @dagger.Provides *;
    @dagger.Binds *;
    @javax.inject.Inject *;
}

# ── Domain & Source Architecture (Anti Tree-Shaking) ──────────────────────────
-keep interface io.aristiyo.core.domain.repository.** { *; }
-keep class io.aristiyo.core.domain.usecase.** { *; }
-keep class io.aristiyo.core.source.TeamRepository { *; }
-keep class io.aristiyo.core.source.local.LocalDataSource { *; }
-keep class io.aristiyo.core.source.remote.RemoteDataSource { *; }

# ── Serialization & Network (Gson / Retrofit) ─────────────────────────────────
-keepclassmembers,allowobfuscation class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
-keep class io.aristiyo.core.source.remote.response.** { *; }
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn retrofit2.**
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# ── UI Components & Utilities ─────────────────────────────────────────────────
-keep class io.aristiyo.core.ui.** { *; }
-keep class io.aristiyo.core.utils.** { *; }
-keep class io.aristiyo.core.source.ResultStatus { *; }
-keep class io.aristiyo.core.source.ResultStatus$** { *; }

# ── Glide & Parcelable ────────────────────────────────────────────────────────
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule { <init>(...); }
-keep class * implements android.os.Parcelable { *; }
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
}