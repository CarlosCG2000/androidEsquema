
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

### 2.1 State
Compose requiere que el `Holder Observable` sea un objeto `State`. Un objeto `State` seria un `observable no mutable`. Imaginar como si `State` fuese una clase abstracta que no tiene el método `set` para poder cambiar el contenido de ese `observable`.

### 2.2 State - MutableState
Este `Holder Observable` extiende de la clase `State` y si tiene el método para poder modificar le objeto contenido del `Holder`.

Entonces si nuestra variable de contador la pasamos a un tipo `MutableState` ya que se debe de poder modificar el contador. El problema es que sigue siendo una variable local y a todos los efectos se destruira después de la ejecución de la función.

### 2.3 Remember
Deberiamos conseguir que las variables perduren la ejecución de la función (Compose) y eso se consigue mediante `remember`.

`Remember` es una función que recibe como parámetro una lambda que lo que permite que el objeto `mutableState` contenido en la lambda extedienda no se destruya al finalizar el método sino que persista fuera del `ciclo de vida` de la función.

Si la variable (objeto) `mutableState` extiende del ciclo de vida, se puede cambiar el valor de la variable (contador). Para poder acceder al valor ahora se deberia de realizar a través de su `.value`.

### 2.3.1 By
La variable con `remember` se puede definir a través de hacer un `=` o a través de `by`.
Si la definimos a través de `by` lo que sucede es que lo que se ponga a la derecha (el `MutableState`) se va a convertir en un `delegado`. Lo que me va a devolver es un `objeto`, donde ese objeto va a contener las propiedades `get` y `set` en función de si lo he definido como `val` o `var`.

Gracias a ello la `instanciación` de el objeto `MutableState` se `retrasa` lo máximo posible, es decir no se va a instanciar hasta que en la secuencia de mi función se llame por primera vez a la variable.

Ahora para llamar al valor no se necesita `value` porque como he comentado ya tiene implicitamente el `get`y `set`.

Si ahora ejecutamos vemos que ahora mi variable por ser `remember` trasciende del ciclo de vida de la función y se actualice el valor de la variable contador por pantalla gracias al `Holder Observable` de tipo `MutableState`.

* ¿Pero que sucede si cambia la pantalla de rotación? El `ciclo de vida` de la aplicación se `reinicia` y la variable igualmente se reinicia y el contador vuelve a valer el `valor inicial`. Ya que cunado cambia la configuración se mata a la actividad y se reinicia el ciclo de vida.

¿Como podiamos restaurar los valores del ciclo de vida? A traves del método `onSave()`.

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

Y hay esta el problema, el problema es que cuando yo recupero la información de una fuente de datos o servicio web esa operacion es muy lenta y eso implica que le hilo que ejecute esa aplicación se a quedr bloqueado a la esspera de rcibir la respueste de la fiente de datos o servicio web.

Que se quede bloqueado es un problema ya que si se queda más d e5 segundos la aplicación falla, segun Andoriod si el hilo principal queda bloqueado durante 5 segundos se entiende que la aplicación no funciona y se rompe.

Por lo tanto todos los datos que se extraigan del repositorio no deben de ejecutarse en el hilo principal ya que se encuerga solo dle interfaz de usuario. Si es otor hilo el que se encarga de la gestión de los datos a todos los efectos habra un hilo que me modfique los datos del View Model y esa modificación, sera `asincrona` con respecto al hilo principal que muestra los datos en la pantalla.



ANDROID Y TAMBIEN COMO ES EN IOS (QUE TIPOS DE HOLDER OBERVABLES TIENE Y SUS FUNCIONALIDADES)

#### MI RESUMEN

#### DUDAS
- ¿Si ese dato (`contador`) solo lo usamos en la pantalla (función composable) no seria mejor dejarlo como un `Holder Observable` (`State` o `MutableState`) en vez de llevarlo a un `View Model`? ¿Lo hiciste solo de ejemplo para ver los `View Model`? ¿Cuando deberia de llevarse a un `View Model`?

- ¿Una `única actividad` en toda la `aplicación`, o cuando deberia tener varias actividades?

- ¿Una `pantalla` tendra un `VM`, pero un `VM` podra tener `muchas pantallas` no?

- ¿Pero entonces no es adecuado llamar a varios VMs en una misma pantalla? ¿Yo por ejemplo necesitos diferentes datos en  diferentes fuentes de datos `Personaje`, `Episodios`, `Citas`, yo tengo una pantalla que necesita todos los datos, no estaria bien llamarlos?

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