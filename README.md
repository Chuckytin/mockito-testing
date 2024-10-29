# Mock Testing Project

Este repositorio contiene prácticas de pruebas unitarias en Java utilizando JUnit y Mockito. 
A través de JUnit y Mockito, se crean pruebas unitarias para verificar el correcto funcionamiento de los métodos de servicio, validando los resultados y el comportamiento de sus dependencias.

### Componentes Principales

1. **`DataProvider`** - Clase que proporciona datos simulados (`mock`) para jugadores.
2. **`PlayerServiceImpl`** - Clase de servicio que implementa la lógica de negocio para manejar jugadores.
3. **`PlayerRepositoryImpl`** - Clase que simula una base de datos en memoria.
4. **`PlayerServiceImplTest`** - Pruebas unitarias para validar los métodos de `PlayerServiceImpl` utilizando Mockito.

## Clases y Funcionalidades

### Clase `DataProvider`

Esta clase contiene métodos estáticos para simular datos de jugadores que se usan en las pruebas unitarias.

- **`playerListMock`**: Retorna una lista de jugadores con datos de ejemplo.
- **`playerMock`**: Retorna un solo jugador de ejemplo.
- **`newPlayerMock`**: Retorna un nuevo jugador que simula una adición en el sistema.

### Clase `PlayerServiceImpl`

Esta clase de servicio implementa la interfaz `IPlayerService` y depende de `PlayerRepositoryImpl` para interactuar con la capa de datos. 

Métodos principales:
- **`findAll()`**: Devuelve una lista de todos los jugadores.
- **`findById(Long id)`**: Busca un jugador por su ID.
- **`save(Player player)`**: Guarda un jugador en la base de datos.
- **`deleteById(Long id)`**: Elimina un jugador por su ID.

### Clase `PlayerRepositoryImpl`

Simula una base de datos en memoria. Implementa la interfaz `IPlayerRepository`, que contiene métodos básicos de CRUD para los jugadores.

Métodos implementados:
- **`findAll()`**
- **`findById(Long id)`**
- **`save(Player player)`**
- **`deleteById(Long id)`**

### Clase de Prueba `PlayerServiceImplTest`

Utiliza JUnit y Mockito para probar los métodos de `PlayerServiceImpl`.

Pruebas incluidas:
1. **`testFindAll()`** - Verifica la funcionalidad de obtener todos los jugadores.
2. **`testFindById()`** - Valida la búsqueda de un jugador por ID.
3. **`testSave()`** - Comprueba que un jugador nuevo pueda ser guardado y que los datos sean correctos.
4. **`testById()`** - Verifica que se pueda eliminar un jugador mediante su ID.
