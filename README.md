# Pokédex Android App

Una aplicación nativa de Android que muestra una lista completa de Pokémon consumiendo los datos directamente desde la [PokéAPI](https://pokeapi.co/).

## 🚀 Características Principales

- **Cuadrícula de Pokémon**: Muestra a los distintos Pokémon en un diseño visual atractivo de cuadrícula de 3 columnas utilizando `GridLayoutManager`.
- **Scroll Infinito (Paginación)**: A medida que el usuario hace scroll hacia abajo, la aplicación carga automáticamente más Pokémon (en lotes de 24), brindando una experiencia de navegación fluida e ininterrumpida.
- **Consumo de API REST**: Se conecta a la web de forma eficiente mediante Retrofit2 para realizar peticiones HTTP.
- **Mapeo de Datos JSON**: Integración nativa con Gson para parsear las respuestas de la API en objetos de Java utilizables por la interfaz.

## 🛠️ Tecnologías y Librerías Utilizadas

- Java - Lenguaje de programación principal.
- Android SDK - Framework base de desarrollo.
- Retrofit 2 - Cliente HTTP seguro para la conexión con el servidor.
- Gson - Biblioteca para la serialización y deserialización de objetos JSON.
- RecyclerView - Componente optimizado para la visualización de listas grandes.

## 📂 Estructura del Proyecto

A grandes rasgos, los componentes principales del proyecto se dividen en:

- `MainActivity.java`: Orquesta la vista principal, inicializa el `RecyclerView` y gestiona la lógica del listener de scroll para cargar los siguientes elementos.
- `PokeapiService.java`: Interfaz donde se definen de manera limpia los endpoints HTTP requeridos por Retrofit.
- `modelos/` (`Pokemon.java`, `PokemonRespuesta.java`): Clases POJO que estructuran y almacenan los datos provenientes de la PokéAPI.
- `ListaPokemonAdapter.java`: Adaptador personalizado que enlaza los datos de cada Pokémon con la vista de la cuadrícula en el `RecyclerView`.

## ⚙️ Cómo ejecutar el proyecto localmente

1. Asegúrate de tener instalado Android Studio.
2. Clona este repositorio en tu máquina local.
3. Abre el proyecto (`d:\Códigos\Pokedex`) utilizando Android Studio.
4. Espera a que Gradle termine de sincronizar todas las dependencias (Retrofit, Gson, AndroidX, etc).
5. Ejecuta la aplicación en un emulador o en tu dispositivo físico Android conectándolo por USB o de forma inalámbrica.

## 📝 Notas

Este proyecto es una excelente demostración técnica de cómo implementar el consumo de APIs externas de forma asíncrona, manejar paginación (scroll infinito) y separar los conceptos de vista, modelos y red dentro de una aplicación de Android utilizando buenas prácticas.

---