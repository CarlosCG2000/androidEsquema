
# PARTE ROBERTO - ANDROID CON KOTLIN Y COMPOSE

# 1_CLASE `06/03/25`

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

# 1_CLASE `07/03/25`

# __________ 0. Índice __________
## 1. ...
# _______________________________

## 1. ...

