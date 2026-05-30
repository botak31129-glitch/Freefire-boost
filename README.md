# FreeFire Boost - Graphics Optimizer

Aplikasi Android untuk optimasi grafis game Free Fire dengan preset khusus untuk perangkat **Oppo A18**.

## 🎮 Fitur Utama

- **Preset Grafis Kustom** untuk Oppo A18:
  - Low Performance Mode
  - Medium Balance Mode
  - High Quality Mode
  - Ultra Performance Mode

- **Pengaturan Grafis Manual**:
  - Brightness (Kecerahan): 0-100%
  - Contrast (Kontras): 0-100%
  - Saturation (Saturasi): 0-100%
  - Sharpness (Ketajaman): 0-100%

- **Manajemen Profil**:
  - Simpan profil custom
  - Load profil yang sudah disimpan
  - Reset ke pengaturan default

## 📱 Persyaratan Sistem

- Android 8.0 (API Level 26) atau lebih tinggi
- Oppo A18 (atau device sejenis)
- RAM minimal 2GB

## 🚀 Memulai

### 1. Clone Repository
```bash
git clone https://github.com/botak31129-glitch/freefire-boost.git
cd freefire-boost
```

### 2. Buka di Android Studio
- Buka Android Studio
- File → Open → Pilih folder `freefire-boost`

### 3. Build & Run
```bash
./gradlew build
./gradlew installDebug
```

## 📁 Struktur Proyek

```
freefire-boost/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── kotlin/com/freefire/boost/
│   │       │   ├── data/
│   │       │   │   ├── local/
│   │       │   │   │   └── PreferencesManager.kt
│   │       │   │   └── model/
│   │       │   │       └── GraphicsPreset.kt
│   │       │   └── ui/
│   │       │       ├── MainActivity.kt
│   │       │       ├── GraphicsAdjustmentActivity.kt
│   │       │       ├── PresetActivity.kt
│   │       │       └── adapter/
│   │       │           └── PresetAdapter.kt
│   │       └── res/
│   │           ├── layout/
│   │           ├── values/
│   │           └── drawable/
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── README.md
```

## 🎯 Penggunaan

1. **Buka Aplikasi**
   - Tekan ikon FreeFire Boost di home screen

2. **Pilih Preset atau Manual Adjust**
   - Klik "Load Presets" untuk preset cepat
   - Atau klik "Adjust Graphics" untuk adjustment manual

3. **Simpan Profil**
   - Setelah menyesuaikan, klik "Save Profile"
   - Profil akan disimpan untuk penggunaan mendatang

4. **Terapkan ke Game**
   - Buka FreeFire
   - Pengaturan grafis akan diterapkan otomatis

## 🔧 Teknologi yang Digunakan

- **Language**: Kotlin
- **Platform**: Android Native
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)
- **Build Tool**: Gradle 7.4.2

## 📚 Dependencies

- AndroidX Core KTX
- AndroidX AppCompat
- Material Design 3
- Coroutines
- Room Database
- Lifecycle

## 🐛 Bug Report & Kontribusi

Jika menemukan bug atau ingin berkontribusi:
1. Fork repository ini
2. Buat branch baru (`git checkout -b feature/AmazingFeature`)
3. Commit perubahan (`git commit -m 'Add AmazingFeature'`)
4. Push ke branch (`git push origin feature/AmazingFeature`)
5. Buka Pull Request

## 📄 Lisensi

Project ini dilisensikan di bawah MIT License - lihat file LICENSE untuk detail.

## 👤 Author

**Botak31129-glitch**
- GitHub: [@botak31129-glitch](https://github.com/botak31129-glitch)

## 🙏 Terima Kasih

Terima kasih telah menggunakan FreeFire Boost! Nikmati game Free Fire dengan grafis yang optimal di Oppo A18 Anda! 🎮✨

---

**Catatan**: Aplikasi ini adalah tools optimasi independen dan tidak terafiliasi dengan Garena atau Free Fire.