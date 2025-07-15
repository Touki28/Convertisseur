# Convertisseur d'Unités – Java Swing

> Un projet Java simple permettant de convertir différentes unités (monnaie, température, distance, vitesse) via une interface graphique Swing.

---

## ✨ Fonctionnalités

- ✅ Conversion **Euro ⇄ Franc**
- ✅ Conversion **Températures** : Celsius, Fahrenheit, Kelvin
- ✅ Conversion **Vitesses** : km/h, m/s, nœuds
- ✅ Conversion **Distances** : kilomètres ⇄ miles terrestres ou nautiques
- ✅ Interface intuitive avec **Java Swing**
- ✅ Gestion des erreurs utilisateur (saisie invalide)

---

## 📁 Structure du projet

### 🧱 Architecture MVC

Ce projet suit le modèle d’architecture **MVC (Modèle–Vue–Contrôleur)**, afin de structurer le code de manière claire et maintenable :

- **Modèle (`metier`)** : Contient la logique de conversion (monnaie, température, vitesse, etc.). Exemple : `Convertisseur.java`.
- **Vue (`ihm`)** : Composants graphiques créés avec Swing. Chaque panneau (`PanelArgent`, `PanelTemperature`, etc.) correspond à une vue dédiée à une catégorie de conversion.
- **Contrôleur (`Controleur.java`)** : Sert de lien entre la vue et le modèle. Il capte les actions utilisateur, appelle les méthodes de conversion appropriées, et met à jour l’affichage.

Cette architecture facilite :
- La séparation des responsabilités
- L’évolutivité (ajout de nouvelles unités ou vues)
- La testabilité du code métier


```text
├── class/                          # 📦 Dossier avec les fichiers compilés
│   └── ...                         #     Fichiers .class générés depuis .java
│
└── src/                            # 💻 Dossier avec les fichiers sources
    │   compile.list                # 🛠️ Liste des fichiers à compiler
    │   Controleur.java             # 🧭 Contrôleur – Fait le lien entre modèle et vue
    │
    ├── ihm/                        # 🎨 Vue – Interface graphique (Java Swing)
    │   ├── Frame.java              #     Fenêtre principale
    │   ├── PanelConvertisseur.java #   Panel principal de conversion
    │   └── PanelMenu.java          #     Menu de navigation
    │
    └── metier/                     # 🧠 Modèle – Logique métier (calculs, données)
        └── Convertisseur.java      #     Contient les formules de conversion
```

---

## ⚙️ Lancer le projet

### Prérequis

- Java 17 ou supérieur

### Compilation

```bash
javac -d bin src/**/*.java
