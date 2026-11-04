# INF4067 – PRINCIPES SOLID 

## Description du projet

Ce projet illustre, avec des exemples en Java, la notion de **couplage / cohésion** et les **cinq principes SOLID** de la conception orientée objet.

Pour chaque notion, le projet contient deux versions du même exemple :

- un **mauvais design** (`...Bad`), qui montre le problème et viole le principe étudié ;
- un **bon design** (`...Good`), qui corrige le problème en respectant le principe.

Chaque fichier est **indépendant** et contient sa propre méthode `main`. Il peut donc être exécuté seul, sans lancer le reste du projet.


## Outils utilisés

- **Langage :** Java
- **IDE :** Visual Studio Code, avec l'extension Java (Extension Pack for Java)
- **Gestion de version :** Git et GitHub (dépôt privé)

## Structure du projet

```
INF4067_SOLID/
├── src/
│   ├── couplage/
│   │   ├── CommandeBad.java
│   │   └── CommandeGood.java
│   ├── srp/
│   │   ├── BookBad.java
│   │   └── BookGood.java
│   ├── ocp/
│   │   ├── AreaCalculatorBad.java
│   │   └── OCP.java
│   ├── lsp/
│   │   ├── mainlspBad.java
│   │   └── mainlspGood.java
│   ├── isp/
│   │   ├── WorkerBad.java
│   │   └── WorkerGood.java
│   ├── dip/
│   │   ├── MainBad.java
│   │   └── MainGood.java
│   └── payment/
│       └── Payment.java
└── README.md
```

Chaque dossier de `src` est un **package Java** portant le nom de la notion étudiée.

## Contenu détaillé

| Package    | Notion étudiée                         | Mauvais design           | Bon design         |
|------------|----------------------------------------|--------------------------|--------------------|
| `couplage` | Couplage faible et forte cohésion      | `CommandeBad.java`       | `CommandeGood.java`|
| `srp`      | Responsabilité unique (SRP)            | `BookBad.java`           | `BookGood.java`    |
| `ocp`      | Ouvert / fermé (OCP)                   | `AreaCalculatorBad.java` | `OCP.java`         |
| `lsp`      | Substitution de Liskov (LSP)           | `mainlspBad.java`        | `mainlspGood.java` |
| `isp`      | Ségrégation des interfaces (ISP)       | `WorkerBad.java`         | `WorkerGood.java`  |
| `dip`      | Inversion des dépendances (DIP)        | `MainBad.java`           | `MainGood.java`    |
| `payment`  | Exemple complémentaire sur l'OCP       | `Payment.java`           | –                  |

### 1. Couplage et cohésion (`couplage`)

- **Mauvais design (`CommandeBad`)** : une même classe calcule le total de la commande **et** la sauvegarde dans MySQL. Elle crée directement un objet `MysqlConnection`. La cohésion est faible et le couplage est fort : changer de base de données oblige à modifier la classe.
- **Bon design (`CommandeGood`)** : la classe `Commande` ne gère que les données et le calcul du total. La classe `CommandeRepository` s'occupe de la sauvegarde et reçoit une interface `BaseDonnees` par injection de dépendances. `MysqlDatabase` implémente cette interface, donc la base de données est interchangeable.

### 2. Responsabilité unique – SRP (`srp`)

- **Mauvais design (`BookBad`)** : une seule classe cumule quatre responsabilités : les données du livre, l'affichage, la sauvegarde en base et la logique d'emprunt.
- **Bon design (`BookGood`)** : chaque responsabilité a sa propre classe : `BookSRP` (données), `BookPrinter` (affichage), `BookSaver` (sauvegarde) et `BookBusinessLogic` (logique métier).

### 3. Ouvert / fermé – OCP (`ocp` et `payment`)

- **Mauvais design (`AreaCalculatorBad`)** : la méthode `calculateArea(Object)` enchaîne des `if instanceof`. Pour ajouter une nouvelle forme, il faut modifier cette méthode.
- **Bon design (`OCP`)** : une interface `Shape` est implémentée par `Rectangle` et `Circle`. `AreaCalculator` travaille avec `Shape`. Pour ajouter une forme, il suffit de créer une nouvelle classe, sans modifier le code existant.
- **Exemple complémentaire (`Payment`)** : la classe `PaymentProcessor` choisit le traitement avec une chaîne de `if / else if` sur le type de paiement. Chaque nouveau moyen de paiement oblige à modifier la méthode `processPayment`, ce qui viole l'OCP.

### 4. Substitution de Liskov – LSP (`lsp`)

- **Mauvais design (`mainlspBad`)** : `SquareBad` hérite de `RectangleBad` et redéfinit les setters pour modifier la largeur et la hauteur ensemble. Utilisé à la place d'un rectangle, un carré donne un résultat inattendu : une aire de 16 au lieu de 20.
- **Bon design (`mainlspGood`)** : `Square` et `Rectangle` n'héritent plus l'une de l'autre. Elles implémentent chacune l'interface `Shape` et calculent leur propre aire, ce qui rend les deux classes substituables.

### 5. Ségrégation des interfaces – ISP (`isp`)

- **Mauvais design (`WorkerBad`)** : l'interface `WorkerBadInterface` est trop large (`work()` et `eat()`). `RobotWorkerBad` doit implémenter `eat()` alors qu'un robot ne mange pas, ce qui lève une `UnsupportedOperationException`.
- **Bon design (`WorkerGood`)** : l'interface est découpée en `Workable` (`work()`) et `Eatable` (`eat()`, qui étend `Workable`). `HumanWorkerGood` implémente `Eatable` et `RobotWorkerGood` implémente seulement `Workable`.

### 6. Inversion des dépendances – DIP (`dip`)

- **Mauvais design (`MainBad`)** : la classe de haut niveau `OrderProcessorBad` crée directement une classe concrète de bas niveau, `MySQLDatabaseBad`. Le couplage est fort.
- **Bon design (`MainGood`)** : `OrderProcessor` dépend de l'interface `Database`, qu'elle reçoit par son constructeur. Les classes `MySQLDatabase` et `MongoDBDatabase` l'implémentent, donc on peut changer de base de données sans modifier `OrderProcessor`.

## Prérequis

- **JDK 11 ou supérieur** installé. Pour vérifier : `java -version` et `javac -version`.
- **Visual Studio Code** avec l'extension **Extension Pack for Java**.

## Exécution

### Avec VS Code (méthode recommandée)

1. Ouvrir le dossier du projet dans VS Code.
2. Ouvrir le fichier à exécuter, par exemple `src/srp/BookBad.java`.
3. Cliquer sur **Run** (le lien « Run | Debug » affiché au-dessus de la méthode `main`).
4. Le résultat s'affiche dans le terminal en bas de la fenêtre.

Chaque fichier a sa propre méthode `main` : pour exécuter un autre exemple, il suffit d'ouvrir son fichier et de cliquer sur son **Run**.


## Remarque

Les diagrammes de classes de chaque exemple ne sont pas inclus dans ce dépôt : ils sont présentés dans le rapport qui accompagne le projet.