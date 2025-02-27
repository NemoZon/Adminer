# ESGI IW S1: BACK-OFFICE ANDROID

## Auteur: BUSHUKIN Gleb

## Description

*L'objectif principal de ce projet est de mettre en place un espace administratif pour la gestion des données des étudiants.*

## Version

*1.0*

## Structure

- **app/src/main/java/com/example/adminer :** Ce dossier contient le code source de l'application.
  - **data :** Ce dossier est responsable de la représentation de la base de données et de l'accès à celle-ci.
    - **entities :** Ce dossier contient une collection d'entités de la base de données.
    - **http :** Ce dossier contient tout ce qui concerne les requêtes API.
    - **mocks :** Ce dossier contient des données fictives.
    - **repositories :** Ce dossier contient des dépôts.
  - **di :** Сe dossier est utilisé pour injecter des dépendances dans le code.
  - **navigation :** Ce dossier contient les pages de l'application.
  - **ui/theme :** Ce dossier contient tout ce qui est lié au design de l'application.
  - **viewmodel :** Ce dossier représente l'état des données dans l'application.
  - **views :** Сe dossier contient des composants réutilisables.
 
## Lancer un projet Android en Kotlin

### Prérequis

Avant de commencer, assurez-vous que vous avez installé les outils suivants :

- [Android Studio](https://developer.android.com/studio) (version recommandée : stable)
- [JDK 11 ou plus récent](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Une version d'Android SDK compatible avec la version de votre projet

### Étapes pour exécuter le projet

1. **Clonez le dépôt**

   Utilisez la commande suivante pour cloner le dépôt de ce projet :

   ```bash
   git clone https://github.com/NemoZon/Adminer/
   ```

2. **Ouvrir le projet dans Android Studio**

   - Lancez [Android Studio](https://developer.android.com/studio).
   - Cliquez sur "Ouvrir un projet" et sélectionnez le dossier cloné du projet.

3. **Synchronisez Gradle**

   - Après avoir ouvert le projet, Android Studio devrait automatiquement détecter les dépendances de Gradle et commencer la synchronisation.
   - Si la synchronisation ne commence pas automatiquement, allez dans le menu `File` > `Sync Project with Gradle Files`.

4. **Configurer un émulateur ou un appareil Android**

   - Si vous utilisez un émulateur Android, assurez-vous qu'il est correctement configuré.
   - Sinon, connectez un appareil Android à votre ordinateur et assurez-vous que le mode `Débogage USB` est activé.

5. **Exécuter le projet**

   - Cliquez sur le bouton "Exécuter" (icône en forme de triangle vert) dans la barre d'outils Android Studio.
   - Choisissez un appareil ou un émulateur sur lequel exécuter l'application.

6. **Vérifiez les logs**

   Pour vérifier que l'application fonctionne correctement, ouvrez la fenêtre `Logcat` dans Android Studio pour voir les logs du projet.

