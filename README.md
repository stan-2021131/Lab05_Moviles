# Laboratorio 5 - Network Access with Retrofit
### Sergio Estuardo Tan Coromac - 24759

Programa con el objetivo de practicar conocimientos sobre navegación entre pantallas, creación de UI's con Jetpack Compose y manejo de consultas a api's externas mediante Retrofit.

## Pantallas
### Pokemon List
Muestra un listado de nombres y sprites principales de los primeros 100 pokemons. Se puede interactuar con las card para dirigirse a los detallas.

<img width="368" height="829" alt="image" src="https://github.com/user-attachments/assets/91dbf399-88cf-45f9-b536-594901a14ae4" />

### Pokemon Detail
Muestra los sprites principales del pokemon seleccionado en la pantalla anterior.

<img width="369" height="833" alt="image" src="https://github.com/user-attachments/assets/34faa0d3-fdaf-45e3-b449-750765868b07" />

## Funcionalidad
Su usaron las librerías:
- Retrofit para hacer consultas al api
- Navigation para moverse entre pantallas
- gson para convertir las respuestas del api para su uso dentro del programa

### model/Pokemon.kt
Modelos de Pokemon, PokemonResponse, PokemonD, Sprites. Todos los modelos son usados para las consultas al api.

<img width="1065" height="569" alt="image" src="https://github.com/user-attachments/assets/efcf9f38-a5ec-4099-909b-8b7cfaeaecdf" />

### api/ApiService.kt
Interface de apiService para las rutas y funciones de las llamadas al api

<img width="823" height="254" alt="image" src="https://github.com/user-attachments/assets/21456a77-6ae2-4364-b938-3b629b8b9a3f" />

### api/RetrofitClient.kt
Configuración inicial y conexión al api de pokemon.

<img width="735" height="397" alt="image" src="https://github.com/user-attachments/assets/91a9ea96-936e-4405-85d9-f6522e041fd6" />

### api/PokemonViewModel.kt
Se hace la llamada al api y la respuesta se almacenan los datos para su uso dentro de las pantallas.

<img width="1296" height="831" alt="image" src="https://github.com/user-attachments/assets/c1cdfe00-2a76-4b41-89ec-a689846b0f9f" />

### navigation/NavHost.kt y Routes.kt
Configuración para la navegación entre pantallas y objeto con las rutas definidas.

<img width="1110" height="778" alt="image" src="https://github.com/user-attachments/assets/14958e92-0c91-432b-bae3-a1dd8da0ba6c" />
<img width="470" height="173" alt="image" src="https://github.com/user-attachments/assets/b243535e-98bd-4503-9400-a3cd6382ef75" />

### screens/PokemonListScreen.kt y PokemonDetailScreen
Composables para las pantallas de listado de pokemons y detallas (Pantallas mostradas al inicio).

<img width="1473" height="827" alt="image" src="https://github.com/user-attachments/assets/c4ff086b-46de-478d-9756-4343a057d27f" />
<img width="1492" height="851" alt="image" src="https://github.com/user-attachments/assets/b9a8a602-2a89-44e6-8a21-f35613397659" />

### MainActivity.kt
Archivo principal donde se inicializa el programa, contiene la navegación para mostrar la pantalla principal.

<img width="598" height="476" alt="image" src="https://github.com/user-attachments/assets/b0c6fad1-0bac-419e-8ba2-360ac7d53af4" />





