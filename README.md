# GUI Based Home Search Engine

**Author:** *Michael Argaw*

---

## 🎯 Objectives

* Demonstrate a strong understanding of software development concepts.
* Apply proper Object-Oriented (OO) techniques to implement a GUI-based home search engine.
* Implement JavaFX for the user interface.
* Allow dynamic addition and search of mock home data during runtime.

---

## 📖 Overview

This project is a JavaFX-based GUI that functions as a simple home search engine. The program uses mock data provided for testing, but it also allows users to add new properties dynamically. The project emphasizes clean code, OO best practices, and functional testing.

The application features:

* Search by city, state, or zip.
* Search by bedrooms and bathrooms.
* Search by square footage (SqFt).
* Search by price range (Min/Max Price).
* Sorting of results using multiple algorithms.
* Exporting search results to a file.
* Optional feature: Add new properties via the GUI.

---

## ⚙️ Setup

1. **Create a Java project** named `YourLastNameHomeSearchEngine`.
2. Ensure **module-info.java** is included.
3. Add **JUnit 5 library** (on the module path) for testing.
4. Follow the **package and class structure**.
5. Include the provided **JSON data file** at the root of the project.
6. Initialize a **Git repository** and commit the setup.

---

## 📂 Project Structure

```
YourLastNameHomeSearchEngine/
│
├─ src/
│   ├─ main/
│   │   ├─ java/
│   │   │   └─ <package_name>/
│   │   │       ├─ Main.java
│   │   │       ├─ Home.java
│   │   │       ├─ DataReader.java
│   │   │       ├─ SearchController.java
│   │   │       └─ ... other classes
│   │   └─ resources/
│   │       └─ homes.json
│   │
├─ test/
│   └─ java/
│       └─ <package_name>/
│           └─ DataReaderTest.java
│
└─ module-info.java
```

---

## 🖥️ Features

* **Responsive GUI:**

  * 100% vertical height, 75% horizontal width.
  * Two-color theme applied throughout.
* **Search Options:**

  * City / State / Zip
  * Bedrooms / Bathrooms
  * Square Footage
  * Min / Max Price
* **Functional Controls:**

  * Execute search
  * Display matches (up to 20 results)
  * Export matches to `search_matches.txt`
* **Error Handling:**

  * Input validation and exception handling for incorrect data types.
* **Sorting:**

  * Implemented two distinct algorithms for different search types (e.g., MergeSort, BubbleSort).

---

## 🧪 Testing

* **DataReader Class:** Ensures correct reading of JSON into objects.
* **Sorting Algorithms:** Validates that results are sorted correctly.
* **Search Functions:** Confirms that each search type returns expected results.
* **Adding Properties:** Ensures newly added homes appear in searches and exports.

---

## 📹 Demo Video

Here you can showcase your project running in Eclipse:

<video width="720" height="480" controls>
  <source src="demo-video.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>

> Replace `demo-video.mp4` with the actual file path or GitHub-hosted link.

---

## 💾 How to Run

1. Clone this repository.
2. Open the project in **Eclipse**.
3. Ensure **JavaFX libraries** are linked.
4. Run `Main.java` to start the application.
5. Use the GUI to perform searches, add homes, and export matches.

---

## 📦 Exported Data

* Matches are exported to `search_matches.txt` at the root of the project.
* Existing files are overwritten on each export.

---

## 📝 Notes

* Only **one search type** can be selected at a time (default: Min/Max Price).
* All string searches are **case-insensitive**.
* Bad input data is gracefully handled without crashing the program.

---

## 🌟 Optional Feature

* Users can add a new property through the GUI.
* Input validation ensures that only correct data is added.
* Added homes appear in subsequent searches and exports.

---

## 📚 References

* JavaFX Documentation: [https://openjfx.io/](https://openjfx.io/)
* JSON Handling in Java: [https://www.json.org/json-en.html](https://www.json.org/json-en.html)
* JUnit 5 Documentation: [https://junit.org/junit5/](https://junit.org/junit5/)

---

