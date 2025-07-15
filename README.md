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

├───class #Dossier avec les fichiers de compilation
│   └───src
│       │   Controleur.class
│       │
│       ├───ihm
│       │       Frame.class
│       │       PanelConvertisseur.class
│       │       PanelMenu.class
│       │
│       └───metier
│               Convertisseur.class
│
└───src # 
    │   compile.list
    │   Controleur.java
    │
    ├───ihm
    │       Frame.java
    │       PanelConvertisseur.java
    │       PanelMenu.java
    │
    └───metier
            Convertisseur.java

---

## ⚙️ Lancer le projet

### Prérequis

- Java 17 ou supérieur

### Compilation

```bash
javac -d bin src/**/*.java
