# Rithu's Stationery Shop — Bill Generator

A simple console-based Java application that generates a bill for a stationery shop. The program displays a price list, lets the user add items with quantities, and prints a final itemized bill including 5% GST.

This README assumes no prior knowledge of the project and walks through every step needed to set it up and run it from scratch.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Environment Setup](#environment-setup)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Running the Project](#running-the-project)
- [Usage Guide](#usage-guide)
- [Sample Run](#sample-run)
- [Configuration](#configuration)
- [Troubleshooting](#troubleshooting)

## Project Overview

`billGenerator` is a single-file Java console application built for a mini-project. It simulates a basic point-of-sale billing system for a stationery shop:

1. It stores a fixed catalog of items and their prices in memory.
2. It prints the catalog to the console.
3. It repeatedly asks the user for an item name and quantity until the user types `done`.
4. It calculates the subtotal, adds 5% GST, and prints a formatted final bill.

## Features

- In-memory price list of 22 common stationery items.
- Input validation for item names (rejects items not in the catalog).
- Supports adding the same item multiple times (quantities are summed).
- Automatically calculates subtotal, GST (5%), and grand total.
- Clean, aligned console output using formatted printing.

## Prerequisites

Before you begin, make sure you have the following installed on your machine:

- **Java Development Kit (JDK) 8 or later** (JDK 17 recommended for long-term support).
- A terminal / command prompt.
- (Optional) An IDE such as IntelliJ IDEA, Eclipse, or VS Code with the Java Extension Pack, if you prefer not to use the command line directly.

You do **not** need any external libraries — the project only uses classes from the Java Standard Library (`java.util.Scanner`, `java.util.Map`, `java.util.LinkedHashMap`).

## Environment Setup

### 1. Install the JDK

**Windows:**
1. Download the JDK installer from [Oracle's JDK downloads page](https://www.oracle.com/java/technologies/downloads/) or use [Eclipse Temurin](https://adoptium.net/).
2. Run the installer and follow the prompts.
3. Add Java to your `PATH` (the installer usually offers to do this automatically).

**macOS:**
```bash
brew install openjdk@17
```

**Linux (Debian/Ubuntu):**
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### 2. Verify the installation

Open a terminal and run:

```bash
java -version
javac -version
```

You should see version output (e.g., `javac 17.0.x`). If you see a "command not found" error, revisit your `PATH` configuration.

## Project Structure

```
your-repository/
├── README.md
└── src/
    └── miniProject/
        └── billGenerator.java
```

> The class `billGenerator` is declared inside `package miniProject;`, so the file **must** live inside a folder named `miniProject` (matching the package name exactly), and you must compile/run it with that package structure in place.

## Installation

There are no external dependencies to install — this is a self-contained Java program. You only need to get the source code onto your machine.

1. **Clone the repository:**
   ```bash
   git clone <your-repository-url>
   cd <your-repository-folder>
   ```

2. **Confirm the folder structure** matches the layout shown above, with `billGenerator.java` inside a `miniProject` folder.

## Running the Project

You can run this project either from the command line or from an IDE.

### Option A: Command Line

1. Navigate to the folder that **contains** the `miniProject` folder (i.e., the `src` folder, or the repository root if `miniProject` is at the top level).

2. Compile the program:
   ```bash
   javac miniProject/billGenerator.java
   ```
   This creates a `billGenerator.class` file inside the `miniProject` folder.

3. Run the program:
   ```bash
   java miniProject.billGenerator
   ```

### Option B: Using an IDE (IntelliJ IDEA / Eclipse / VS Code)

1. Open the project folder in your IDE.
2. Make sure the folder containing `billGenerator.java` is marked as a **source root** (so the `miniProject` package is recognized correctly).
3. Locate `billGenerator.java`, right-click it, and choose **Run** (or click the "Run" arrow next to the `main` method).

## Usage Guide

Once the program starts:

1. It prints a welcome message and a table of all available items with their prices.
2. You will be prompted: `Enter item name to add (or 'done' to finish):`
   - Type the **exact item name** as shown in the table (e.g., `Pen`, `Notebook`, `Stapler`). Item names are case-sensitive matches against the catalog keys shown.
   - If the item is not recognized, you'll see an error message and be prompted again.
3. After entering a valid item, you'll be asked: `Enter quantity for <item>:`
   - Enter a whole number (e.g., `2`).
4. Repeat steps 2–3 for as many items as you like.
5. Type `done` when you are finished adding items.
6. The program prints the final itemized bill, including subtotal, 5% GST, and the grand total.

## Sample Run

```
📚 Welcome to Rithu's Stationery Shop
==============================================
Item                 Price (₹)
----------------------------------------------
Pen                  ₹10.00
Pencil               ₹5.00
Notebook             ₹40.00
...
==============================================

Enter item name to add (or 'done' to finish): Pen
Enter quantity for Pen: 3

Enter item name to add (or 'done' to finish): Notebook
Enter quantity for Notebook: 2

Enter item name to add (or 'done' to finish): done

🧾 Final Bill:
-----------------------------------------------------
Item                 Qty        Total (₹)
-----------------------------------------------------
Pen                  3          ₹30.00
Notebook             2          ₹80.00
-----------------------------------------------------
Subtotal                       ₹110.00
GST (5%)                       ₹5.50
Grand Total                    ₹115.50
=====================================================
🙏 Thank you for shopping with us!
```

## Configuration

There are no external configuration files, environment variables, or API keys required. If you want to change the item catalog or prices, edit the `priceList.put("ItemName", price);` lines near the top of `main()` in `billGenerator.java` and recompile.

## Troubleshooting

| Problem | Likely Cause | Fix |
|---|---|---|
| `error: package miniProject does not exist` or class not found | Wrong working directory or broken folder structure | Make sure you compile/run from the parent of the `miniProject` folder, and that the `.java` file is actually inside a folder named `miniProject`. |
| `NumberFormatException` when entering quantity | Non-numeric input entered for quantity | Enter a whole number only (e.g., `2`, not `two` or `2.5`). |
| Item always shows "❌ Item not found!" | Typo or case mismatch in item name | Re-check the exact spelling/case shown in the printed price table. |
| Rupee symbol (₹) or emojis show as `?` or boxes | Terminal encoding isn't set to UTF-8 | Run with `java -Dfile.encoding=UTF-8 miniProject.billGenerator`, or change your terminal's encoding settings to UTF-8. |
| `javac`/`java` not recognized | JDK not installed or not on `PATH` | Reinstall the JDK and ensure it's added to your system `PATH`, then restart your terminal. |
