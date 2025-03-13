
# PARTE `ROBERTO` - `INTRODUCCIÓN ANDROID CON KOTLIN Y COMPOSE`

# 1_CLASE `05/03/25`

# __________ 0. Índice __________
## 1. Ver lo mismo en el `Android_Grado.md`
## 2. Creamos proyecto `primeraAppCompose`
### 2.1. Ver como es una `actividad`
### 2.2. `Interfaz` de usuario
### 2.3. Lineas `logs`
### 2.4. `Recursos`
# _______________________________

## 1. Ver lo mismo en el `Android_Grado.md`

### `(1)` CLASE 30/01/25
1. Componentes `Actividad`, `Servicio`, `Broadcast receiver`, `Content Providers`
2. Componente `Actividad`
    1. Manifiesto `AndroidManifest.xml`
    2. Funcionamiento `Ciclo de vida` de las actividades
3. IDE `Android Studio`

### `(2)` CLASE 05/02/25
1. Recursos (`res`)
    1. Recurso de valores (`res/values`)
        1. Recursos de valores de identificadores `ids`
        2. Recursos de valores de cadenas de carácteres `strings`
2. `Comandos de ayuda` en el IDE de Android Studio

### `(3)` CLASE 06/02/25
1. Recursos de valores `strings` a la vez con `parámetros` y `estilos`
2. Recursos de valores `plurals`
3. Recursos de valores de `arrays`
4. Recursos de valores de `colors`

### `(4)` CLASE 12/02/25
1. Recursos `Layout` - colocación de `elementos` en un `pantalla`
    1. Tipos de `View Group`
        1. `FrameLayout`
        2. `CardView`
        3. `LinearLayout`

### `(5)` CLASE 13/02/25
1. `Unidades de medida`
2. Seguimos de la última clase, por layout `LinearLayout`
    1. Propiedad peso: `layout_weight` y `weightSum`
3. Layout `Constrains Layout`

### `(6)` CLASE 19/02/25
1. Seguimos con `Contraint Layout`
    1. Repasamos el `posicionamiento común`
    2. Repasamos los `sesgos` (posicionamiento)
    3. Repasamos las `dimensiones`
    4. Lo nuevo las `cadenas`(con estilos)
    5. Repasamos los `pesos` (dimensiones)

### `(7)` CLASE 20/02/25
1. Seguimos con `Contraint Layout`
    1. El `ratio`. Nueva propiedad dentro de la `dimensión`
    2. El `circle`. Nueva propiedad dentro de la `posición`
    3. Las `guias`. Nuevo tipo de layout: `Guidelines`
2. Primera App - Proyecto `Contador`
    1. Implementación de los `layout en la vista`
    2. Creación de la `lógica`
    3. Implementación de un `método`
        1. `Tres formas` de llamar al `interface`
    4. Creación de recurso `Strings`

### `(8)` CLASE 26/02/25
1. Segunda App - Proyecto `Widgets`
    1. Creamos `vista básica`
    2. `Código` en nuestra `lógica`, de la `vista básica`
    3. Botón `ToggleButton`
        1. Interfaz
        2. Lógica
    4. Generar `lineas de log`

### `(9)` CLASE 27/02/25
1. Seguimos con el proyecto `Widgets`
    1. Botón `Switch`
    2. Botón `CheckBox`
    3. Botón `RadioButton`
    4. Botón `TextField`
    5. `ViewBinding`: sustituir la búsqueda de layouts `findViewById()` por una forma automática
    6. Tip: `filtro de error`


## 2. Creamos proyecto `primeraAppCompose`

Desarrollo de la primera app a partir de `minuto 57:00`

Android Studio: `New Proyect` --> `Empty Activity` (Compose)
- Al ser `Compose` (obliga a ser solo con `Kotlin`)

Ya dentro de la App:
- Podemos ver la jerarquía de archivos en varios formas distintas como `Proyect, Packages, Android, ...`

### 2.1. Ver como es una `actividad`
 - Se declara en el `AndroidManifest.xml` y se define en un fichero de `Kotlin` con la interface de `ComponentActivity()`.
- Dentro de la actividad se puede invocar a todos `los métodos del ciclo de vida (9)`: `onCreate, onStart, onRestoreInstanceState, onResume, onPause, onSaveInstanceState, onStop, onRestart, onDestroy`.
El `ciclo de vida` se ejecuta por el `SO automaticamente`, no por nosotros.

### 2.2. `Interfaz` de usuario
- Puede tener una interfaz a través de `Compose` o `View` dependiendo del `setContent`. Podemos tener en un proyecto `una combinación` de actividades con pantallas de un tipo y del otro.
- Puede tener un `Preview` si utilizamos interfaz a través de `Compose`.

### 2.3. Lineas `logs`
¿Como `simular una destrucción` de la app de `forma automática`?
- Me voy a la carpeta del usuario:`cd`
- Luego voy hasta la direccion: ` cd Library/Android/sdk/platform-tools`
- Ejecutamos: `./adb shell am kill es.upsa.primeraappcompose`, sabiendo que `es.upsa.primeraappcompose` es el nombre del paquete de la aplicación.

### 2.4. `Recursos`
Incampie en recursos `Strings` (cadena de caracteres). `No` definirlos como `literales` sino como `recursos` para vincularlos con `internacionalización`.

- Hay muchos tipo de recursos no solo de `Strings` tambien de `colors`, `plurals`, `arrays`, etc.
Ojo no se define igual en la interfaz de `@Compose`:
```java
@Composable // Quiere decir que va a definir una interface de usuario
fun Greeting(name: String, modifier: Modifier = Modifier) { // Con parámetros por defecto

    val saludo = stringResource(R.string.saludo) // Recurso de String
    //...
}
```

Que dentro de cualquier `método de la actividad`:
```java
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val saludo = getString(R.string.saludo) // Recurso de String
    //...
}
```

- `Internalización`, através del botón `Open editor`, dentro del archivo de recursos `Strings`.
`Automaticamente` crea un `nuevo fichero` para la` traducción en el idioma` que hayamos seleccionado.
Mediante atajos se pueden crear las variables como recurso `strings`.

# 2_CLASE `06/03/25`

# __________ 0. Índice __________
## 1. Respecto a `Kotlin`. El método `setContent`
### 1.1. Explicación `expresiones Lambda`
## 2. ¿Ques un `ViewGroup`?
## 3. ViewGroup `FrameLayout` - `Box`
### 3.1. Vista
### 3.2. Compose
## 4. ViewGroup `LinearLayout` - `Column`|`Row`
### 4.1. Vista
### 4.2. Compose
### 4.3. Realizar `ejercicio 1`
## 5. ViewGroup `ConstrainLayout` - `ConstraintLayout`
### 5.1. Vista
### 5.2. Compose
# _______________________________

Vamos a ver como diseñar los interface tanto mediante vistas pero sobretodo con Compose.
Creamos nuevo proyecto a través de Kotlin y Compose llamado `Layouts`.

## 1. Respecto a `Kotlin`. El método `setContent`
Si queriamos definir una intefaz de usuario teniamos que invocar desde nuestra actividad con el método `setContent`que heredabamos de la actividad.

El `setContent` es un método formado por dos parámetros:
1. `CompositionContext` por defecto es un null.
2.  `Expresión lambda` que es la que nosotros estamos añadiendo. La cual tiene 0 párametros y no devuelve ningun parámetro.

```java
    public fun ComponentActivity.setContent(
        parent: CompositionContext? = null, // 1 parámetro (CompositionContext)
        content: @Composable (() -> Unit) // 2 parámetro (expresión lambda)
    ): Unit
```

```java
    /*public fun ComponentActivity.*/setContent(
        // parent: CompositionContext? = null, // No hace falt por defect ya es null
        // content: @Composable (() -> Unit) // Es una expresión lambda, sin parámetros (y sin devolver nada)
    ){ // Aqui es donde se define la expresión lambda
        // sentencias...
    }
```

### 1.1. Explicación `expresiones Lambda`
```java
    // 1. Expresión lambda con más de un parámetro
    val funcionLambda: (Int, Int) -> Unit = { num1, num2 ->
        // sentencias.......
    }

    // 2. Expresión lambda con uno (o cero) parámetros
    // Si solo es un parámetro se puede omitir el pasarselo y se utiliza 'it' por defecto como dicho parámetro. Si no se pasa ningun parámetro tambien se puede omitir la flecha.
    val funcionLambda: (Int) -> Unit = { /* num1 -> */
        // sentencias con el parámetro it.......
    }

    // 3. Función
    // Si ahora tengo una función y tengo como parámetro un expresión lambda
    fun xxx(f: (Int, Int)->Unit):Unit {

    }

    // Para la invocación de la función al solo tener como parametro una expresión lambda se permite no poner los parentesis y escribir a continuación la expresión lambda
    xxx/*()*/ {
        p1, p2 -> sentencias
    }
```

## 2. ¿Ques un `ViewGroup`?
Todas las vistas (`Button, TextView, ViewGroup, etc`) extienden de `View`.
Un `ViewGroup` sirve para extructurar las vistas. Y hay distintos `ViewGroup` dependiendo de la organización.
Un `ViewGroup` al ser una vista puede contener a la vez varios `ViewGroup`.
Hay 3 tipos de `ViewGroup` dependendiendo de la organización: `FrameLayout`, `LinearLayout`, `ConstrainLayout`.

## 3. ViewGroup `FrameLayout` - `Box`

### 3.1. Vista
Tiene que ser un `recurso (res)` de `tipo Layout`.
Nombre del fichero `frame_layout` y 'root element' ponerlo como `FrameLayout`.

Es un `XML` donde solo puede conteneder como elemento raiz una única `ViewGroup` (vista).
Siempre tienen que tener `unas dimesiones` (ancho y alto) de si es en unidad exacta utilizar `dp` (para ser proporcionales en todos los dispositivos).

Atributos:
Se puede colocar en una de las 9 referencias que hay, dando una posición horizontal y vertical.
- `gravity`: `android:layout_gravity="bottom|end"`

### 3.2. Compose
Creamos dentro de la lógica un paquete que llamamos `screens` y un fichero llamado `FrameLayout`

Creamos un método `@Composable` y otra `Preview`.

- El método `@Composable`.
Equivale al método `Box`: actual se le pueden pasar atributos como `modifier` (el cual puede tener otros atributos para darle forma, color, tamaño, etc), `contentAlignment`, `propagateMinConstraints`, etc.

Y tenemos dentro del `Box` otras vistas como pueden ser `Textview` o `Button` de las cual de la misma forma son métodos que pueden atributos como `modifier`, etc.

- El método `Preview`.
Es la preview donde se pueden personalizar los elementos con las caracteristicas que tiene que tener mi visualizador gráfico. Desde `la rueda` se puede configurar.

## 4. ViewGroup `LinearLayout` - `Column`|`Row`

### 4.1. Vista
Tiene que ser un `recurso (res)` de `tipo Layout`.
Nombre del fichero `linear_layout` y 'root element' ponerlo como `LinearLayout`.

Un `Linear` me distribuye las vistas que contiene, una a continuación de la otra. La orientación puede ser
`vertical` u `horizontal`.

Si se elegi con una orientación dicha orientanción no se podria modificar sobre el elemento solo la otra otrientación.

Atributos:
- `gravity`: `android:layout_gravity="center"` o en el padre raiz `android:gravity="bottom"`

### 4.2. Compose
Creamos dentro de la lógica en el paquete `screens` un fichero llamado `LinearLayout`

Creamos un método `@Composable` y otra `Preview`.

- El método `@Composable`.
Equivale al método `Column`|`Row`.

No hay `margin` sino solo usa `padding`.
Se pueden asignar `pesos` através del `Modifier`: `.weight(1f)` mediante un float

- El método `Preview`.

### 4.3. Realizar `ejercicio 1`
En el minuto 1:48:39

## 5. ViewGroup `ConstrainLayout` - `ConstraintLayout`
Tiene que ser un `recurso (res)` de `tipo Layout`.
Nombre del fichero `constraint_layout` y 'root element' ponerlo como `xxx`. No deja hacerlo porque hay que añadir las librerias correspondientes.

- Añadir un `libreria` para poder utilizar `ConstrainLayout` en Compose.

Vamos a `File` --> `Proyect Structure` --> `Dependencies` --> `Add Library Dependency` --> Buscamos por `constraintlayout` --> Pulsamos a la `libreria normal` --> Realizamos los mismo pasos para en vez de la libreria normal recoger la de `constraintlayout compose`.

Nombre del fichero `constraint_layout` y 'root element' ponerlo como `androidx.constraintlayout.widget.ConstraintLayout`.

### 5.1. Vista
Ya visto en apuntes de la asignatura del grado en el readme `Android_Grado.md`

### 5.2. Compose
- El método `@Composable` y `Preview`.

Asignarle `id`, `bias (sesgos)` y peso con dimensión `0dp (que dependa del contraints)`.

Propiedad principales:
- definir ids: `val (idBtA, idBtB, idBtC) = CreateRefs()`
- llamar ids: `Modifier.costraintAs(id)`
- enlazar con otros layout: `top.linkTo(idBtC.bottom)`, baseline, top, bottom, start, end

Resumen `ConstraintLayout` con Compose:

Ya luego lo hago....



# 3_CLASE `12/03/25`

# __________ 0. Índice __________
## 1.
## ...
# _______________________________

Creamos un nuevo proyecto `03_ContadorApp`. En Compose (con Kotlin).
Vamos a hacer una aplicacion simple, para entender varios conceptos. La aplicación tiene que tener este diseño.






```java
// Con 'remember': mi variable transciende mi ciclo de vida de mi aplicación
// Esto es un 'holder' que permites que las vistas sean 'observables' respecto esta variable
var contador by rememberSaveable { mutableStateof() } // con 'by' se crea un delegado, se crea un objeto con lo que definimos con un 'get' y 'set' (solo 'get' si se crea con un 'val')

// El problema es que con el cambio de ciclo de vida (cuando giramos la pantalla por ejemplo) se reinicia la variable.
// La solución el ciclo de vida guardar en el bundle para al restaurarse el ciclo de vida
//Cambiamos 'remember' por 'rememberSaveable'

//Datos locales a la pantalla
// Datos de la fuente externas de la logica de mi aplicación es para lo que se utiliza el concepto de ViewModel

// El ciclo de vida delview model transciende el ciclo de vida de mi actividad.
// El VM no se ve adectado por los cambio de configuracion del telefono. Es el sitio dieal donde guardar el estado de la actividiad, los datos necesarios para las disitintas pantalla de la actividad.
// Una actividad puede ter uno o N viewModels vinculados a la actividad cuando se necesite.
// Lo normal es tener un VM por cada actividad y una actividad tiene muchos vistas (Composable).
// rendremos un VM por pantalla el VM es el quien tiene lso emtodos que gestion el estado de la pantalla, si por ejempñplo procede de una fuente externa con un repositorio y queremos el estado de productos.

//Ya no necesitamos remeber si lo ponemos en un VM porque como comentamos trasciende de los ajsutes del dispositos.

// Vm puede recuperar informacion de un repositorio y de esta de una base de datos. Y hay esta el prblema cuando lo hago en una base de datos o paguina web esto es muy lenyto y se va a quedar bloqueada la interfaz. Si es superior a 5 segundos la aplicaicon falla,s egun android si se para mas de 5 seg se parara.
```

```java


```