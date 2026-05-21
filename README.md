[![CircleCI](https://dl.circleci.com/status-badge/img/circleci/2ygcR8gChcoDqMdgmYNVyb/JgtDhaZprLtmVpKEbYjGvZ/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/circleci/2ygcR8gChcoDqMdgmYNVyb/JgtDhaZprLtmVpKEbYjGvZ/tree/main)

---

# 🎓 Capstone Dicoding MADE Submission

> **Menjadi Android Developer Expert (MADE)** — Capstone Project  
> Aplikasi Android multi-modul dengan arsitektur Clean Architecture, Dependency Injection (Hilt), dan Dynamic Feature Module.

---

## 📱 Tentang Aplikasi

Aplikasi ini merupakan submission akhir (Capstone) dari kelas **Menjadi Android Developer Expert** di Dicoding Indonesia. Dibangun menggunakan pendekatan **modular multi-project** dengan standar arsitektur Android modern: Clean Architecture, Repository Pattern, dan Dependency Injection menggunakan Hilt.

---

## 🏗️ Arsitektur & Struktur Modul

Proyek ini terdiri dari **3 modul utama**:

```
CapstoneDicodingMADESubmission/
├── app/                  # Main application module
├── core/                 # Shared library: data, domain, DI
├── favouritefeature/     # Dynamic Feature Module (Favourite)
├── .circleci/            # CI/CD configuration (CircleCI)
└── build.gradle.kts      # Root build configuration
```

### Penjelasan Modul

| Modul               | Tipe            | Deskripsi                                                                                              |
|---------------------|-----------------|--------------------------------------------------------------------------------------------------------|
| `:app`              | Application     | Entry point aplikasi. Mengelola navigasi dan UI utama.                                                 |
| `:core`             | Android Library | Berisi data layer (Room, Retrofit), domain layer (UseCase, Repository interface), dan Hilt DI modules. |
| `:favouritefeature` | Dynamic Feature | Fitur favorit yang di-load secara dinamis (on-demand) untuk mengurangi ukuran APK awal.                |

---

## 🔧 Tech Stack

| Kategori                 | Library / Tool                 |
|--------------------------|--------------------------------|
| **Bahasa**               | Kotlin 100%                    |
| **Dependency Injection** | Dagger Hilt                    |
| **Annotation Processor** | KSP (Kotlin Symbol Processing) |
| **Arsitektur**           | Clean Architecture + MVVM      |
| **Fitur Dinamis**        | Android Dynamic Feature Module |
| **CI/CD**                | CircleCI                       |
| **Build System**         | Gradle (Kotlin DSL `.kts`)     |

---

## 🚀 Cara Menjalankan Proyek

### Prasyarat
- Android Studio Hedgehog atau lebih baru
- JDK 17+
- Android SDK minimal API 21

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

---

## 🧩 Fitur Utama

- **Daftar Item** — Menampilkan daftar data dari remote API
- **Detail Item** — Tampilan detail dari item yang dipilih
- **Favorit** *(Dynamic Feature)* — Simpan dan kelola item favorit secara lokal
- **Offline Support** — Data di-cache menggunakan Room Database

---

## 🔄 CI/CD

Proyek ini dilengkapi konfigurasi **CircleCI** (`.circleci/config.yml`) untuk:
- Build otomatis setiap push ke branch `main`
- Menjalankan unit test secara otomatis

---

## 📐 Pola Arsitektur

```
UI Layer (Fragment/Activity/ViewModel)
        ↕
Domain Layer (UseCase — ada di :core)
        ↕
Data Layer (Repository, Room, Retrofit — ada di :core)
```

Modul `:favouritefeature` mengakses domain layer dari `:core` melalui Hilt dependency injection, tanpa ketergantungan langsung ke modul `:app`.

---

## 📂 Dependensi Antar Modul

```
:app ──────────────▶ :core
  │
  └──── (dynamic) ──▶ :favouritefeature ──▶ :core
```

---

## 👤 Author

**Aristhio**  
GitHub: [@aristhiooo](https://github.com/aristhiooo)

---

## 📄 Lisensi

Proyek ini dibuat sebagai submission kelas Dicoding dan tidak dilisensikan untuk distribusi komersial.

---

*Dibuat dengan ❤️ sebagai bagian dari program belajar [Dicoding Indonesia](https://www.dicoding.com)*

---

## Catatan Pengerjaan Submission
**1. Menerapkan Continuous Integration.**
- Tool yang digunakan adalah **CircleCI**
- Link project CI : https://app.circleci.com/projects/circleci/2ygcR8gChcoDqMdgmYNVyb/JgtDhaZprLtmVpKEbYjGvZ

**2. Memiliki performa yang baik**
- Menerapkan Leak Canary dan tidak ada memory leaks saat dianalisa.

**3. Menerapkan Security**
- Menerapkan obfuscation dengan ProGuard.
- Menerapkan encryption pada database. (Lokasi file : core/src/main/java/io/aristiyo/core/di/DatabaseModule.kt)
- Menerapkan certificate pinning untuk koneksi ke server. (Lokasi file : core/src/main/java/io/aristiyo/core/di/NetworkModule.kt)

**4. Mempertahankan syarat yang ada pada submission sebelumnya.**

**5. Saran untuk Penilaian**

- Menerapkan tampilan aplikasi yang sangat menarik dan sesuai standar

- Tidak menggunakan kode yang sama dengan yang di modul. Misal menggunakan Rx, menggunakan Dagger,  tidak menggunakan NetworkBoundResource. **(Dagger-Hilt dan Flow)**

- Hampir tidak ada issue pada semua aspek saat dilakukan Inspect Code.

- Menerapkan Continuous Integration dengan analisis lainnya seperti code coverage **(Kover)**, code style **(Ktlint Gradle)**, dan vulnerability **(OWASP Dependency-Check)**.

- Menerapkan security selain yang telah diajarkan. **(Credential Separation)**

---

Thanks