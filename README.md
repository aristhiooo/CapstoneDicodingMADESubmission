[![CircleCI](https://dl.circleci.com/status-badge/img/circleci/2ygcR8gChcoDqMdgmYNVyb/JgtDhaZprLtmVpKEbYjGvZ/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/circleci/2ygcR8gChcoDqMdgmYNVyb/JgtDhaZprLtmVpKEbYjGvZ/tree/main)

---

# 🎓 Capstone Dicoding MADE Submission

> **Menjadi Android Developer Expert (MADE)** — Capstone Project
> Aplikasi browser tim **English Premier League** berbasis Android multi-modul dengan Clean Architecture, Dependency Injection (Hilt), dan Dynamic Feature Module.

---

## 📱 Tentang Aplikasi

Aplikasi ini adalah submission akhir (Capstone) dari kelas **Menjadi Android Developer Expert** di Dicoding Indonesia. Aplikasi menampilkan data tim-tim di **English Premier League** menggunakan [TheSportsDB API](https://www.thesportsdb.com/api.php), dilengkapi fitur favorit yang dapat diakses secara offline.

Dibangun dengan pendekatan **modular multi-project** menggunakan standar arsitektur Android modern: Clean Architecture, Repository Pattern, NetworkBoundResource, dan Dependency Injection menggunakan Hilt.

---

## 🏗️ Arsitektur & Struktur Modul

Proyek ini terdiri dari **3 modul utama**:

```
CapstoneDicodingMADESubmission/
├── app/                  # Main application module (Entry point, navigasi, UI utama)
├── core/                 # Shared library: data layer, domain layer, DI modules
├── favouritefeature/     # Dynamic Feature Module (Fitur Favourit, on-demand)
├── .circleci/            # CI/CD configuration (CircleCI)
├── gradle/
│   └── libs.versions.toml  # Version catalog (TOML)
└── build.gradle.kts      # Root build configuration (Kotlin DSL)
```

### Penjelasan Modul

| Modul               | Tipe            | Package                        | Deskripsi                                                                                                                     |
|---------------------|-----------------|--------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| `:app`              | Application     | `io.aristiyo.capstone`         | Entry point. Mengelola navigasi (Navigation Component), screen Home, dan screen Detail tim.                                   |
| `:core`             | Android Library | `io.aristiyo.core`             | Berisi data layer (Room + SQLCipher, Retrofit), domain layer (UseCase, Repository interface), Hilt DI, dan shared UI adapter. |
| `:favouritefeature` | Dynamic Feature | `io.aristiyo.favouritefeature` | Fitur favorit yang di-load secara on-demand untuk mengurangi ukuran APK awal. Mengakses domain `:core` via Hilt.              |

---

## 🔧 Tech Stack

| Kategori                  | Library / Tool                                          | Versi (libs.versions.toml) |
|---------------------------|---------------------------------------------------------|----------------------------|
| **Bahasa**                | Kotlin 100%                                             | 2.3.21                     |
| **UI**                    | ViewBinding, RecyclerView, ConstraintLayout, Material 3 | —                          |
| **Navigasi**              | Navigation Component (Fragment KTX + Dynamic Features)  | 2.9.8                      |
| **Dependency Injection**  | Dagger Hilt                                             | 2.59.2                     |
| **Annotation Processor**  | KSP (Kotlin Symbol Processing)                          | 2.3.7                      |
| **Arsitektur**            | Clean Architecture + MVVM                               | —                          |
| **Database Lokal**        | Room KTX + SQLCipher (enkripsi)                         | 2.8.4 / 4.16.0             |
| **Networking**            | Retrofit 3 + OkHttp (Certificate Pinning)               | 3.0.0 / 5.3.2              |
| **Async**                 | Kotlin Coroutines + Flow                                | 1.11.0                     |
| **Image Loading**         | Glide                                                   | 5.0.7                      |
| **Logging**               | Timber                                                  | 5.0.1                      |
| **Memory Leak Detection** | LeakCanary                                              | 2.14                       |
| **Fitur Dinamis**         | Android Dynamic Feature Module                          | —                          |
| **Build System**          | Gradle Kotlin DSL (`.kts`) + Version Catalog            | AGP 9.2.1                  |
| **CI/CD**                 | CircleCI                                                | —                          |
| **Code Style**            | Ktlint Gradle                                           | 14.2.0                     |
| **Code Coverage**         | Kover                                                   | 0.9.8                      |

---

## 🚀 Cara Menjalankan Proyek

### Prasyarat

- Android Studio Hedgehog atau lebih baru
- JDK 21
- Android SDK minimal API 24 (Android 7.0 Nougat)
- Target SDK 36 (Android 16)

> ⚠️ Proyek ini menggunakan **compileSdk 36 (release API)** — pastikan SDK Platform 36 sudah terinstall di Android Studio SDK Manager.

### Langkah-langkah

1. **Clone repositori**
   ```bash
   git clone https://github.com/aristhiooo/CapstoneDicodingMADESubmission.git
   cd CapstoneDicodingMADESubmission
   ```

2. **Buka di Android Studio**
   File → Open → pilih folder hasil clone

3. **Sync Gradle**
   Klik **Sync Now** di notifikasi Android Studio, atau jalankan:
   ```bash
   ./gradlew build
   ```

4. **Jalankan aplikasi**
   Pilih device/emulator → klik ▶ Run

> 💡 **Catatan untuk Dynamic Feature**: Fitur Favourit menggunakan Dynamic Feature Module. Untuk menguji di emulator, pastikan Google Play Store tersedia atau gunakan `adb install-multiple`.

---

## 🧩 Fitur Utama

- **Daftar Tim EPL** — Menampilkan seluruh tim di English Premier League dari TheSportsDB API, di-cache secara lokal dengan Room.
- **Detail Tim** — Informasi lengkap tim: badge, fanart, stadion, kapasitas, deskripsi, warna kit, media sosial, dan tahun berdiri.
- **Favourit** *(Dynamic Feature)* — Simpan dan kelola tim favorit secara lokal. Module ini di-load on-demand.
- **Offline Support** — Data di-cache ke Room Database terenkripsi (SQLCipher). Koneksi internet hanya dibutuhkan saat pertama kali membuka atau data kosong.
- **Kit Color Indicator** — Menampilkan warna utama dan sekunder jersey tim secara visual.

---

## 🔄 CI/CD

Proyek ini dilengkapi konfigurasi **CircleCI** (`.circleci/config.yml`) untuk pipeline otomatis di setiap push ke branch `main`:

| Stage              | Tool                   | Keterangan                                      |
|--------------------|------------------------|-------------------------------------------------|
| Build & Test       | Gradle + JUnit         | Kompilasi proyek dan menjalankan unit test      |
| Code Coverage      | Kover                  | Mengukur persentase kode yang tercakup test     |
| Code Style         | Ktlint Gradle          | Memvalidasi gaya penulisan kode Kotlin          |

🔗 Link project CI: https://app.circleci.com/projects/circleci/2ygcR8gChcoDqMdgmYNVyb/JgtDhaZprLtmVpKEbYjGvZ

---

## 📐 Pola Arsitektur

```
┌─────────────────────────────────────────┐
│           UI Layer (:app)               │
│  Fragment / Activity / ViewModel        │
└─────────────┬───────────────────────────┘
              │  UseCase
┌─────────────▼───────────────────────────┐
│         Domain Layer (:core)            │
│  TeamUseCase / ITeamsRepository         │
└─────────────┬───────────────────────────┘
              │  Repository
┌─────────────▼───────────────────────────┐
│          Data Layer (:core)             │
│  TeamRepository → NetworkBoundResource  │
│  ├── RemoteDataSource (Retrofit)        │
│  └── LocalDataSource  (Room + SQLCipher)│
└─────────────────────────────────────────┘
```

### Alur Data (NetworkBoundResource)

```
getAllTeams()
    │
    ├─→ loadFromDB() → emit cached data (Flow)
    │
    └─→ shouldFetch()?
           │
           YES → createCall() → Retrofit API
                     │
                     └─→ saveCallResult() → Room DB
                                │
                                └─→ loadFromDB() → emit fresh data (Flow)
```

Modul `:favouritefeature` mengakses domain layer dari `:core` melalui Hilt `@EntryPoint`, tanpa ketergantungan langsung ke modul `:app`.

---

## 📂 Dependensi Antar Modul

```
:app ──────────────────▶ :core
  │
  └──── (dynamic) ──────▶ :favouritefeature ──▶ :core
```

`:favouritefeature` tidak bergantung ke `:app` — ia hanya bergantung ke `:core` via Hilt `FavouriteComponent` dan `ViewModelFactory` custom untuk mendukung dynamic feature module.

---

## 🔐 Keamanan

| Aspek                     | Implementasi                                                                                         |
|---------------------------|------------------------------------------------------------------------------------------------------|
| **Obfuscation**           | ProGuard aktif di build `debug` dan `release` (`isMinifyEnabled = true`, `isShrinkResources = true`) |
| **Database Encryption**   | SQLCipher via `SupportOpenHelperFactory` — password dari `BuildConfig.ENCRYPTION_PASSWORD`           |
| **Certificate Pinning**   | OkHttp `CertificatePinner` dengan 2 pin (primary + backup) dari `BuildConfig.CERTIFICATE_PIN`        |
| **Credential Separation** | Semua secret (base URL, pin, password DB) disimpan di `BuildConfig` — tidak di-hardcode di kode      |
| **Memory Leak Detection** | LeakCanary aktif di debug build                                                                      |

---

## 📊 Perkiraan Persentase Penggunaan AI

> ⚠️ Bagian ini adalah **estimasi** berdasarkan analisis pola kode dan kompleksitas proyek. Tidak ada cara pasti untuk mengukur ini tanpa catatan eksplisit.

| Area Pengerjaan                                     | Estimasi AI | Keterangan                                                                                    |
|-----------------------------------------------------|:-----------:|-----------------------------------------------------------------------------------------------|
| Setup arsitektur multi-modul (Hilt, KSP, DFM)       |    ~50%     | Struktur boilerplate DI + dynamic feature cukup kompleks dan umum di-generate AI              |
| Data layer (Room, Retrofit, NetworkBoundResource)   |    ~40%     | Pola NetworkBoundResource mengikuti template standar; mapper dan DAO cukup umum               |
| Domain layer (UseCase, Repository interface)        |    ~30%     | Relatif sederhana, kemungkinan ditulis manual dengan referensi kelas Dicoding                 |
| UI layer (Fragment, ViewModel, Adapter)             |    ~25%     | Logika UI spesifik aplikasi, lebih banyak ditulis manual                                      |
| Security (SQLCipher, Certificate Pinning, ProGuard) |    ~45%     | Konfigurasi security mengikuti pola yang sangat umum didokumentasikan / di-generate           |
| CI/CD (CircleCI config)                             |    ~60%     | YAML pipeline CI/CD adalah area yang sangat umum dibantu AI                                   |
| README & dokumentasi                                |    ~70%     | Struktur dan gaya penulisan README menunjukkan bantuan AI yang signifikan                     |
| **Estimasi Keseluruhan Proyek**                     |  **~40%**   | Mayoritas logika bisnis dan UI ditulis secara manual; AI membantu scaffolding dan boilerplate |

**Metodologi estimasi:** Analisis didasarkan pada (1) pola kode yang sangat seragam dan konsisten, (2) penggunaan template standar industri yang tepat tanpa variasi, (3) struktur dokumentasi yang terformat rapi, dan (4) kompleksitas konfigurasi yang tinggi di area seperti DI dan CI/CD.

---

## 📄 Catatan Pengerjaan Submission

**1. Continuous Integration**
- Tool: **CircleCI** — build dan unit test otomatis di setiap push ke `main`
- Tambahan: **Kover** (code coverage), **Ktlint** (code style)
- Link: https://app.circleci.com/projects/circleci/2ygcR8gChcoDqMdgmYNVyb/JgtDhaZprLtmVpKEbYjGvZ

**2. Performa**
- LeakCanary terpasang — tidak ada memory leak terdeteksi
- ProGuard aktif di semua build type untuk mengurangi ukuran dan meningkatkan performa runtime

**3. Keamanan**
- Obfuscation via ProGuard (`isMinifyEnabled = true` di debug & release)
- Enkripsi database dengan SQLCipher (`core/src/main/java/io/aristiyo/core/di/DatabaseModule.kt`)
- Certificate pinning via OkHttp (`core/src/main/java/io/aristiyo/core/di/NetworkModule.kt`)
- Credential separation — semua secret hanya ada di `BuildConfig`, tidak di source code

**4. Keunggulan Teknis**
- Menggunakan **Dagger-Hilt** (bukan Koin atau manual DI) dengan **KSP** sebagai annotation processor
- Menggunakan **Flow** (bukan LiveData atau RxJava) secara konsisten di seluruh data layer
- Tidak menggunakan `NetworkBoundResource` versi kelas Dicoding — diimplementasikan ulang secara custom
- Hampir tidak ada issue saat **Inspect Code** dijalankan di Android Studio
- Implementasi CI dengan analisis tambahan: **Kover** (code coverage), **Ktlint** (code style)
- Security tambahan: **Credential Separation** via `BuildConfig` yang di-inject melalui Gradle

---

## 👤 Author

**Aristhio**
GitHub: [@aristhiooo](https://github.com/aristhiooo)

---

## 📄 Lisensi

Proyek ini dibuat sebagai submission kelas Dicoding dan tidak dilisensikan untuk distribusi komersial.

---

*Dibuat dengan ❤️ sebagai bagian dari program belajar [Dicoding Indonesia](https://www.dicoding.com)*