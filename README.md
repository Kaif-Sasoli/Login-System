# 🔐 Login System (JavaFX)

A desktop-based **Login System** built using **JavaFX** that allows users to create accounts, log in, view their dashboard, and delete accounts. User data is stored using **XML file handling** with JAXB. The project also includes a **Windows installable `.msi` package**.

---

## ✨ Features

- User Registration (Create Account)
- User Login Authentication
- Dashboard with User Details
- Delete Account Functionality
- XML-based Data Storage (File Handling)
- Modern JavaFX UI
- Windows Installable `.msi` File

---

## 🛠 Technologies Used

- **Java**
- **JavaFX**
- **FXML**
- **JAXB (XML Binding)**
- **File I/O**
- **CSS (UI Styling)**

---

## 📂 Project Structure

```
LoginSystem/
├── src/
│ ├── controller/
│ ├── model/
│ ├── service/
│ └── utils/
├── resources/
│ ├── fxml/
│ └── css/
├── README.md
├── build.xml
└── LoginSystem-1.0.msi
```

---

## 📸 Screenshots

### 🔑 Sign In / Create Account
![Sign In](SignIn.png)

### 📊 User Dashboard
![Dashboard](Dashboard.png)

---

## 💾 Data Storage

- User data is stored in an **XML file**
- File location: ```C:\Users<YourUsername>.loginSystem\user.xml```

- Managed using **JAXB marshalling and unmarshalling**

---

## 📦 Installation (Windows)

You can install the application using the provided installer: ``` LoginSystem-1.0.msi```


Simply double-click the file and follow the installation steps.

---

## ▶️ How to Run (From Source)

1. Clone the repository:
   ```bash
   git clone https://github.com/Kaif-Sasoli/Login-System.git
2. Open the project in IntelliJ IDEA or NetBeans

3. Configure JavaFX properly

4. Run the main JavaFX application class

---
## ⚠️ Notes

* Passwords are stored in plain text (for learning purposes only)

* This project is intended for educational/demo use

* Not recommended for production without encryption

---
## 👨‍💻 Author

### Kaif Sasoli

---

### ✅ How to use it
1. Open your `README.md`
2. **Paste everything above**
3. Save
4. Commit & push

If you want next:
- 🔒 Password hashing (SHA-256)
- 🧹 Code cleanup & refactor
- 🚀 GitHub Release notes
- 🏷 Badges (Java | JavaFX | Windows)



