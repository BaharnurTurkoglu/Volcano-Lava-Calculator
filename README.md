# 🌋 Volcano Lava Puddle Calculator (CENG 113)

This project is a Java-based algorithmic solution developed to calculate the maximum amount of hot lava that can be trapped within specific rock formations in a valley.

## 📋 Project Overview
* **Goal**: To calculate the total number of cells filled with hot lava for a given 1D rock formation array.
* **Input**: The program accepts 10 integers representing the heights of rock formations in a valley.
* **Core Logic**: The solution identifies local depressions (puddles) where lava can accumulate without overflowing.

## 🛠 Technical Implementation
The algorithm determines the "filling factor" for each cell by evaluating the maximum heights to its left and right.

* **Language**: Java.
* **Key Methods**:
    * `puddle()`: Handles data input and initialization.
    * `fillFactor()`: Calculates the potential lava height for a specific index based on its boundaries.
    * `findLeftMaxValueIndex` / `findRightMaxValueIndex`: Identifies the containment walls for the lava.
* **Course Context**: Developed as part of CENG113 - Computer Programming I at AYBU Computer Engineering Dept.

## 🚀 Example Run
**Input Terrain:**
`8 3 2 1 6 0 7 3 2 5`

**Execution:**
The program iterates through the formation, filling the gaps until no more lava can be contained.

**Output:**
`There can be maximum observable amount of hot lava is (in cells): 28`

---
**Assignment Date:** 03/12/2022  
**Developer:** Baharnur Türkoğlu
