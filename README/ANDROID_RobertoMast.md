
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
## 1. Interfaz
## 2. Holder Observable
## 3. View Model
### 3.1 Fichero de View Model: `ContadorViewModel.kt`
### 3.2 `Holder Observable` tipo `StateFlow` y `MutableStateFlow`
### 3.3 `.collectAsState()` - Convertir en `Holder Observable` (tipo `State`)
### 3.4 Objeto `SavedStateHandle`
## 4. Otros componetes en la `interfaz`
## 5. `Factory` - Personalizar `View Model`
## 6. Preguntas
### 6.1 Profesor
### 6.2 Chat GPT
# _______________________________

Creamos un nuevo proyecto `03_ContadorApp`. En Compose (con Kotlin).
Vamos a hacer una aplicacion simple, para entender varios conceptos. La aplicación tiene que tener este diseño.

IMAGEN [1_interfazContador]

Creamos un paquete `screens` dentro otro paquete `contador` y dentro el fichero `ContadorScreen.kt`.

## 1. Interfaz
En `ContadorScreen.kt`, primero dibujamos la interfaz.

Añadimos la libreria de ConstraintLayout: `androidx.constraintlayout` y elegimos `constraintlayout-compose`.

Lo vamos a `modular` invocando a una función que lo que nos devuelva sea el `conjunto de restricciones` y luego aplicamos esas restricciones en nuestro `ConstraintLayout` que solo contendra la definición de que `elementos graficos va a tener` quedando mas limpio al separar sus restricciones.

- Para `posicionar` un elemento por un `porcentaje`: posicionamos centrado y le damos un `sesgo`.
- Para `dimensionar` un cuadrado o circulo `perfecto`: damos una dimensión y luego un `ratio` para la otra.
- Para `alinear` los botones: creamos `una cadena horizontal` con los dos botones, viene a ser el sustituto de `Column` y `Row` en `Constraints`. Esta cadena puede tener sus propios `Constraints`.

## 2. Holder Observable
* ¿Que queremos mostrar en el Box y que queremos lógica de acción a través de los botones?
La idea es que al pulsar el boton de incrementación (+) se sume un número en el Box y viceversa para el boton de decrementenar (-) se reste un número en el Box.

Lo primero que necesitariamos es `una variable de tipo entero` que lo que muestre el dato en el Box y yo pueda incrementarlo y decrementarlo las acciones de los botones.

¿Que pasa? `No hace nada`, por mucho que pulsemos los botones no se incrementa o decrementa la variable.

A todos los efectos la vista (Composable) es una función y la variable es una variable local de la función por lo que una vez ejecutada la aplicación las variables locales se destruyen.

¿Como gestionamos el `estado de las variables` de la pantalla? Aqui entra el concepto de que las vistas (Compose) necesitan `Holder Observables`.

¿Un `Holder` que es? Es un `objeto (o variable)` cuyo único proposito es contener otro objeto. Normalmente estos `Holder` son genericos yo me defino uno que pueda generar un `String`, `Int`, `Producto`.

¿Que quiere decir que sea `observable`? Quiere decir que los `Holder` se van a poder subcribir `observadores`, de forma que si el `Holder muta` (cambio su valor), el `Holder` notificará automaticamente a todos sus `observadores` del cambio que se a producido enviandoles el nuevo dato. Los observadores ahora con ese nuevo dato podran realizar lo que necesiten con él.

El `holder` es `observable` en el sentido de que puede haber otros `objetos`, que se `subcriban a él`, esos objetos se denominan `observadores`. Y los observasdores va a recibir esos `nuevos datos` que contiene el `Holder`. Esto quiere decir, que puede haber `otros objetos` que sean los que cambien el dato `contenido del Holder`, si estos datos me provoca que el` holder cambie` el dato `automaticamente` se lo `notifica` a todos los `observadores` y se le enviará el nuevo dato.

`¿Compose por que lo necesita?` Lo necesita porque cuando `cambie el estado del objeto` automaticamente va a `recomponer` todos los `vistas` (Composables) en donde se utilice ese `Holder`. Los distintos `elementos` se convertiran en `observadores` si ese holder reaccionarian volviendo a pintar todo el composable siempre que el holder cambie el valor.

* Hay distintos `tipos` de `Holder Observable`.

### 2.1 `Holder Observable` tipo State - `State`
Compose requiere que el `Holder Observable` sea un objeto `State`. Un objeto `State` seria un `observable no mutable`. Imaginar como si `State` fuese una clase abstracta que no tiene el método `set` para poder cambiar el contenido de ese `observable`.

### 2.2 `Holder Observable` tipo State - `MutableState`
Este `Holder Observable` extiende de la clase `State` y si tiene el método para poder modificar le objeto contenido del `Holder`.

Entonces si nuestra variable de contador la pasamos a un tipo `MutableState` ya que se debe de poder modificar el contador. El problema es que sigue siendo una variable local y a todos los efectos se destruira después de la ejecución de la función.

### 2.3 Remember
Deberiamos conseguir que las variables perduren la ejecución de la función (Compose) y eso se consigue mediante `remember`.

`Remember` es una función que recibe como parámetro una lambda que lo que permite que el objeto `mutableState` contenido en la lambda extedienda no se destruya al finalizar el método sino que persista fuera del `ciclo de vida` de la función.

Si la variable (objeto) `mutableState` extiende del ciclo de vida, se puede cambiar el valor de la variable (contador). Para poder acceder al valor ahora se deberia de realizar a través de su `.value`.

#### 2.3.1 By
La variable con `remember` se puede definir a través de hacer un `=` o a través de `by`.
Si la definimos a través de `by` lo que sucede es que lo que se ponga a la derecha (el `MutableState`) se va a convertir en un `delegado`. Lo que me va a devolver es un `objeto`, donde ese objeto va a contener las propiedades `get` y `set` en función de si lo he definido como `val` o `var`.

Gracias a ello la `instanciación` de el objeto `MutableState` se `retrasa` lo máximo posible, es decir no se va a instanciar hasta que en la secuencia de mi función se llame por primera vez a la variable.

Ahora para llamar al valor no se necesita `value` porque como he comentado ya tiene implicitamente el `get`y `set`.

Si ahora ejecutamos vemos que ahora mi variable por ser `remember` trasciende del ciclo de vida de la función y se actualice el valor de la variable contador por pantalla gracias al `Holder Observable` de tipo `MutableState`.

* ¿Pero que sucede si cambia la pantalla de rotación? El `ciclo de vida` de la aplicación se `reinicia` y la variable igualmente se reinicia y el contador vuelve a valer el `valor inicial`. Ya que cunado cambia la configuración se mata a la actividad y se reinicia el ciclo de vida.

¿Como podiamos restaurar los valores del ciclo de vida? A través del método `onSave()`.

### 2.4 RememberSaveable
`RememberSaveable` a diferencia de `remember` que recuerda el dato entre recomposiciones y sin encambio `rememberSaveable` realiza lo mismo pero al final `almacena` el valor en el `bundle` para el ciclo de vida. Y por lo tanto aunque haya reconfiguración (reocmposición) posteriormente segun esta programado Compose y su Actividad recuperan el valor de ese `bundle` y no necesita inicializar la variable con el valor por defecto.

Ahora si volvemos a ejecutar por mucho que cambiemos de posición el dispositivo al guardar el ultimo valor en el bundle no pasa nada que se mate la actividad y se reinicie el ciclo de vida ya que a través del bundle recuperará el valor ya que ha sido almacenado.

## 3. View Model
* Generalmente definiremos como variables de tipo `MutableState` datos que sean `locales a la pantalla` y para aquellos otros datos que no sean locales a la pantalla sino que r`epresenten el estado` de mi pantalla de forma que ese estado pueda proceder de una `fuente externa`, como una BD, servicio web, etc de la lógica de mi aplicación en todos los eventos, es para lo que se define el concepto de `View Model`.

El `View Model`, es un objeto. El ciclo de vida del `View Model` trasciende el ciclo de vida de una actividad. Eso significa que si yo giro el teléfono y originalmente mi actividad llamaba a un View Model,
al girar el teléfono esa actividad muere y se crea una nueva actividad que va a recuperar el View Model y va a ser el mismo objeto View Model, porque el View Model  no se ve afectado por los cambios de configuración del teléfono. Al no verse afecto el View Model es el objeto ideal donde nosotros podamos almacenar el estado de la actividad, lo que es lo mismo los datos que necesita la actividad para mostrar, o lo que es lo mismo los datos que son necesarios para las distintas pantallas de la actividad.

Anteriormente `una actividad` siempre tenia `un View Model`. Una actividad en verdad puede tener `un` View Model o `n` `View Models`. Se peude tener tantos View Model vinculados a la activdad como se necesiten.  Y estariamos en las misma si yo cambio la configuración del telefono, la nueva actividad recuperaria los mismos objetos View Model.

Generalmente `ahora` las aplicaciones tienen una `única actividad` y `muchas pantallas` (funciones Composables).

Manteniendo el mismo concepto tendremos ahora un `View Model` por `pantalla` (función Composable). Ya que el `View Model` tendra el `estado de la pantalla`. El `View Model` tendra `los métodos` que gestionen el estado del pantalla. Quiero eso decir, que si el `estado de la pantalla` procede de una `fuente externa`, y nosotros tenemos un `repositorio` y queremos el `estado de productos`. Mi `View Model` tendra que tener `un método` que sera invocado en `mi pantalla` que sea que a través de `mi repositorio` mande al objeto desde la `fuente de datos` correspondiente que me proporcione `los datos`. Y la modificación de los datos desde el `View Model` sera notificada a las distintas vistas `Composables`.

Esquema: `Fuente de datos` -> `Repositorio` -> `View Model` -> `Pantalla (Compose)` -> `Actividad`

IMAGEN [2_cicloApp]

En nuestra aplicación del contador.
La variable `contador` la puedo definir como `variable local` un `Holder Observable` (`State` o `MutableState`) de mi `pantalla` (función `Composable`) o me puedo crear un `View Model` y hacer que el `View Model` sea el que contenga mi `variable contador`.

Generalmente cuando definamos una pantalla tendremos una paquete para pantallas y cada pantalla se dividira con su View Model. Creamos dentro del paquete `screens/contador` donde ya se encuemtra la pantalla `ContadorScreen.kt` nuestro View Model `ContadorViewModel.kt`.

### 3.1 Fichero de View Model: `ContadorViewModel.kt`
- Extiende siempre de `ViewModel()`
- La variable contador sera un `Holder Observable` de tipo `MutableState` pero ya no necesita ser `remember` porque el `View Model` transciende directamente del ciclo de vida de la actividad, por lo tanto tambien de las pantallas (funciones Composable) donde se encuentre.

* Volvemos la función Compose (pantalla).
Añadimos la dependencia: `androidx.lifecycle` llamada `lifecycle-viewmodel-compose`. Descartamos versiones `alpha` coger la última que no sea de este tipo.
- Existe una función `ViewModel()` que seria la que recuperase el viewModel de `ContadorViewModel.kt` de la actividad donde se muestra el composable.

Ahora no estaria bien que las `operaciones de la variable` que se encuentran en el `View Model` se realizasen en los botones de la `pantalla`. Si no que dichas operaciones se tiene que hacer dentro del `View Model` a través de funciones y luego ya en el composable (pantalla) se llama a dichas `funciones` a través del `View Model`.

Si nosotros ejecutamos funciona perfectamente.

Hay que tener en cuenta que el View Model puede recupera rla información de un repositorio. Y el repositorio a su vez puede obtener información de una funete de datos (BD, de una API, Json, etc.)

### 3.2 `Holder Observable` tipo `StateFlow` y `MutableStateFlow`
Y hay esta el problema, el problema es que cuando yo recupero la información de una fuente de datos o servicio web esa operacion es muy lenta y eso implica que le hilo que ejecute esa aplicación se a quedr bloqueado a la esspera de recibir la respueste de la fiente de datos o servicio web.

Que se quede bloqueado es un problema ya que si se queda más d e5 segundos la aplicación falla, segun Andoriod si el hilo principal queda bloqueado durante 5 segundos se entiende que la aplicación no funciona y se rompe.

Por lo tanto todos los datos que se extraigan del repositorio no deben de ejecutarse en el hilo principal ya que se encuerga solo dle interfaz de usuario. Si es otor hilo el que se encarga de la gestión de los datos a todos los efectos habra un hilo que me modfique los datos del View Model y esa modificación, sera `asincrona` con respecto al hilo principal que muestra los datos en la pantalla.

Por lo cual el `Holder Observable` que tenemos que no puede ser ni `State` ni `MutableState` sino `MutableStateFlow`.

Ya que el `Holder State` (`State` o `MutableState`) es un `Holder` sincrono. Por lo que quien modifica el valor del holder es el mismo que notifica a los observadores y por tanto es el mismo hilo que ejecuta el código del observador. Ese hilo es el principal.

Por lo tanto el hilo que notifique al Holder no tiene que ser el mismo hilo que notifique a los composables. Por lo tanto el hilo del Holder no tiene que ser sincrono sino asincrono (no bloqueante).

En el View Model se crearan dos variablesde contador:
- `_contador`; versión privada y mutable con la que se realizaran las operaciones en el View Model.
- `contador`: versión publica e inmutable que recibira el valor de `_contador` y solo servira para proporcionar a los observadores que se puedan subcribir a él y notificarlos cuando cambia el estado, es decir cuando cambie `_contador`.

### 3.3 `.collectAsState()` - Convertir en `Holder Observable` (tipo `State`)
* Volvemos la función Compose (pantalla).
Los `Composables` necesitan si o si `Holder sincrono` (ya que son `interfaces` y estas deben estar en el  `hilo principal`). Es decir necesitamos que se convierta la variables del View Model a `Holder Observable` tipo `State`y esos se realiza con `.collectAsState()`.

Cuando la variable contador cambie de valor (en el View Model), automaticamente cambiara mi variable contador (del Compose) y se actualizara dicha vista. Ya que se habra creado un observador para el State de la variable.

Ejecutamos y funciona perfectamente.

### 3.4 Objeto `SavedStateHandle`
Seguimos con el View Model.
Deciamos que el View Model tranciende del ciclo de vida de la actividad resistiendo a los cambios de la configuración de esta.

¿Pero que pasa si el proceso de la actividad lo mata el sistema operativo poruqe necesita mas recursos asumiendo que esta la actividad en Stoppted (no visible)? Vemos que el View Model si transciende el ciclo de vida de las actividades en tanto que se reseteen los cambios de configuración pero si la actividad se recree como consecuencia de que ha sido el sistema operativo quine la ha matado, hay se genera un nuevo View Model perdiendo todo los datos de este e inicializandose por defecto estos.

Entonces necesitamos en el View Model salvar el estado de sus variables para que se almacenen en el bundle para el método de ciclo de vida del `save()`.

Para ello en la clase del View Model como parámetro hay que pasarle un objeto `SavedStateHandle`.

Y ahora solo se declara `una variable contador` (con `StateFlow`: hilo secundario, inmutable) y se recoge el `valor del bundle` que es el que se modifica y se pasa a las vistas a la vez.

Ejecutamos y funciona perfectamente.

* Entonces podemos tenerlos datos de nuestro View Model definidos o bien a través de un `_contador` con `MutableStateFlow` o a través del `SavedStateHandle` todo a va en función de de la experiencia que queremos que tenga el usuario en nuestra aplicación. Si queremos que al final el usario sigua viendo el mismo estado de la actividad cuando nosotros sabemos que el sistema operativo puede matar esa actividad.

Pero vemos que idnependientemente que se reciba o no los datos del `SavedStateHandle` la obtención de la variable del View Model se relazia exactamente igual en los observables (vistas compose que se subscriben al View Model).

## 4. Otros componetes en la `interfaz`
Creamos un `Slider` acorde a la variable del contador y que realize la misma función que los dos botones decrementar e incrementar.

En el `View Model` creamos un nuevo `método que modifique la variable de contador` y esa será la `operación` que realice el `Slider`.

Entonces como `resultado` vemos que `independientemente del composable` (box, button, slider...) que se haga mutar a la `variable contador` del `View Model`, este se va a actualizar, `actualizando` además a todos los `composables` a los que esta `subcrito` dicha variable.

## 5. `Factory` - Personalizar `View Model`
Vamos a hacer ahora a personalizar View Model puede recibir otros parámetros.
Es decir, tenemos que modificar nuestro constructor para que pueda recibir parámetros.

- Vamos a poner que el valor inicial de la variable contador no sea 0 si no uno que nosotros especifiquemos.
- Si un View model recivbe parametros que no estan predeterminados como el `SavedStateHandle` necesaria mente tenemos que crearnos un `Factory` a través del que  vamos a poder crear estos objetos `View Model`.

Los `Factory` se definen a través de atributos estáticos o métodos estáticos (dentro de `companion object`).

- En la clase del View Model se añade el parámetro que quieres añadir.
- En una función estática (` dentro del companion object`) se define el `Factory` el cuál en su método de creación tendra que llamar a través de los parámetros que se le pase al `View Model `con sus parámetros definidos.
- Luego en las `vistas observables (Compose)` se le pasará como parámetro `factory` el método `factory`.

Por tanto, nosotros cuando definimos un `View Model` podemos personalizar los `parámetros` que vamos a recibir en nuestro `View Model`. Para ello a través de una objeto estático tenemos que definir `un Factory`, es decir un objeto que defina como vamos a crear los `View Model` donde se puedan definir `parámetros` del constructor del View Model.

Más adelante cuando veamos `la inyección de dependecias` veremos que al `constructor del View Model` se le pueden `inyectar los datos`.



ANDROID Y TAMBIEN COMO ES EN IOS (QUE TIPOS DE HOLDER OBERVABLES TIENE Y SUS FUNCIONALIDADES)

## 6. Preguntas

### 6.1 Profesor

1. ¿Si ese dato (`contador`) solo lo usamos en la pantalla (función composable) no seria mejor dejarlo como un `Holder Observable` (`State` o `MutableState`) en vez de llevarlo a un `View Model`? ¿Lo hiciste solo de ejemplo para ver los `View Model`? ¿Cuando deberia de llevarse a un `View Model`?

✅ Sí, si el dato solo es relevante para la pantalla actual y no se necesita compartir con otras, usa remember o rememberSaveable.

❌ No, si el dato necesita persistir entre recomposiciones y cambios de configuración y/o debe ser compartido entre varias pantallas, usa ViewModel.

💡 Ejemplo:
• @State en SwiftUI o remember en Compose si el contador solo afecta a un Button.
• ViewModel si el contador se usa en varias pantallas.

2. ¿Una `única actividad` en toda la `aplicación`, o cuando deberia tener varias actividades?

✅ Una única Activity con Navigation Compose → Recomendado para arquitecturas modernas.
	•	Permite manejar pantallas con Composable sin necesidad de crear múltiples Activity.
	•	Mejora el rendimiento y evita problemas de ciclo de vida.

💡 Conclusión: La mejor práctica actual es tener una sola Activity y manejar la navegación con Navigation Compose.

3. ¿Una `pantalla` tendra un `VM`, pero un `VM` podra tener `muchas pantallas` y `una pantalla` muchos `View Models`?

✅ Sí, una misma pantalla puede tener varios ViewModel si necesitar varios datos de diferente responsabilidad.
✅ Sí, cada pantalla suele tener su ViewModel para mantener separación de responsabilidades.
✅ Sí, un ViewModel puede manejar varias pantallas si tienen datos comunes (ej. un ViewModel de autenticación).
❌ No es recomendable usar un ViewModel para muchas pantallas si manejan datos distintos.

💡 No abuses de esto. Si un ViewModel ya maneja datos relacionados, no crees otro innecesario.

✅ Conclusión general
• Si el dato solo lo usa una pantalla, usa `State` o `remember`.
• Si debe persistir recomposiciones, usa `rememberSaveable`.
• Si el `dato es compartido` entre pantallas o debe sobrevivir cambios de configuración, usa `ViewModel`.
• Una sola `Activity` con `Navigation Compose` es lo recomendado.
• Puedes usar `múltiples ViewModel` en una `pantalla`, pero `no abuses de ellos`.

🔹 Android (`Jetpack Compose`) y iOS (`SwiftUI`) tienen principios similares, pero cada uno usa sus propias herramientas (StateFlow, LiveData en Android y @StateObject, @ObservedObject en SwiftUI). 🚀

### 6.2 Chat GPT

1. ¿Qué tipos de `Holder Observables` existen y sus funcionalidades (tanto para `Android Compose` como `iOS SwiftUI`)?
🔹 `Android (Jetpack Compose)`
En Jetpack Compose, los datos observables pueden almacenarse en diferentes holders según el alcance y persistencia que se necesite:

- remember + mutableStateOf (State<T>)
• Se usa cuando el estado no necesita persistir más allá de la recomposición de una sola pantalla.
```java
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Button(onClick = { count++ }) {
        Text("Count: $count")
    }
}
```

- rememberSaveable (State<T>)
• Similar a remember, pero persiste en cambios de configuración (como rotación de pantalla).
```java
var count by rememberSaveable { mutableStateOf(0) }
```

- LiveData o MutableStateFlow en ViewModel
• Cuando el estado necesita persistir más allá del ciclo de vida de la pantalla (sobrevive a recomposiciones y cambios de configuración).
```java
class MyViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    fun increment() {
        _count.value++
    }
}
```

-	remember { viewModel<MyViewModel>() }
```java
val viewModel: MyViewModel = viewModel()
val count by viewModel.count.collectAsState()
```

🔹 `iOS (SwiftUI)`
SwiftUI maneja los estados observables con distintos wrappers:
- @State (Local)
• Equivalente a remember { mutableStateOf(...) } en Compose.
• Se usa cuando solo la vista actual lo necesita.
```swift
struct CounterView: View {
    @State private var count = 0
    var body: some View {
        Button("Count: \(count)") {
            count += 1
        }
    }
}
```

- @StateObject (ViewModel)
• Se usa cuando el estado necesita persistir fuera de la vista.
• Similar a usar viewModel<MyViewModel>() en Jetpack Compose.
```swift
class CounterViewModel: ObservableObject {
    @Published var count = 0
}

struct CounterView: View {
    @StateObject var viewModel = CounterViewModel()
    var body: some View {
        Button("Count: \(viewModel.count)") {
            viewModel.count += 1
        }
    }
}
```

- @ObservedObject (Compartido entre vistas)
• Similar a remember { viewModel() } en Jetpack Compose cuando se pasa un ViewModel entre vistas.
```swift
struct CounterView: View {
    @ObservedObject var viewModel: CounterViewModel
    var body: some View {
        Button("Count: \(viewModel.count)") {
            viewModel.count += 1
        }
    }
}
```

2. ¿Por qué se `necesita` un `Factory` en un `ViewModel`?
Por defecto, el `ViewModelProvider` solo puede `instanciar un ViewModel` con un constructor `vacío`. Si tu ViewModel necesita parámetros (por ejemplo, un `repositorio`), necesitas un Factory para pasarle esos valores.

- Entonces sirve por si tenemos un repositorio en producción y uno en test o algo asi?
¡Exacto! Un `ViewModel Factory` es útil cuando necesitas proporcionar diferentes `implementaciones de dependencias`, como un repositorio de producción y otro de pruebas (test).

🎯 Ventajas
✅ `Flexibilidad` → Puedes cambiar entre producción y test fácilmente.
✅ `Testabilidad` → Facilita las pruebas unitarias sin necesidad de depender de una API real.
✅ `Inyección de dependencias` → Separa la lógica de obtención de datos del ViewModel.

Si usas `Hilt/Dagger`, puedes evitar el Factory y usar inyección de dependencias directamente. Pero si no usas Hilt, un ViewModelFactory es una buena práctica. 🚀

3. Que `diferencias` hay entre el `VM` en `Android (Kotlin + Compose)` y `iOS (SwiftUI)`

Tanto en `Android` (Kotlin + Jetpack Compose) como en `iOS` (SwiftUI), el `ViewModel` tiene el mismo propósito:` manejar la lógica de negocio`, `gestionar el estado` y `separarlo de la UI`. Sin embargo, hay `diferencias` clave en su implementación y ciclo de vida

📌 Principales Diferencias Resumidas
- `Ciclo de vida`: En Android el ViewModel sobrevive a cambios de configuración. En iOS, si no se usa @StateObject, se recrea en cada renderizado.
- `Manejo de estado`: Android usa StateFlow o LiveData, mientras que iOS usa @Published.
- `Manejo de concurrencia`: Android usa Kotlin Coroutines, iOS usa Combine o async/await.
- `Inyección de dependencias`: Android usa Hilt, en iOS se maneja manualmente o con EnvironmentObject.

En resumen, la` idea es la misma` en ambos sistemas, pero la `implementación y el ciclo de vida` varían según la plataforma. 🚀


# 4_CLASE `13/03/25`

# __________ 0. Índice __________
## 1. 
# _______________________________

Vamos a crear un nuevo proyecto `04_ListadoContactos`. En Compose (con Kotlin).
Vamos a diseñar una aplicación más completa con `arquitectura de View Model` y navegación entre `dos pantalla`s una con un listado de contactos y la otra con los detalles de cada contacto.

## 1. 