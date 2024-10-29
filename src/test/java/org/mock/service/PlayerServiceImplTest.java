package org.mock.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;
import org.mock.persistence.entity.service.PlayerServiceImpl;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.crypto.Data;

import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class) //habilita las anotaciones
public class PlayerServiceImplTest {

    //JUnit trabaja con la clase que testea (Service)
    //Mockito trabaja con la dependencia (Repository)

    @Mock
    private PlayerRepositoryImpl playerRepository; //dependencia

    @InjectMocks
    private PlayerServiceImpl playerService; //clase que se va a implementar

    /*
    // Otra forma de implementar mock en lugar de @ExtendWith()
    @BeforeEach
    void init() {
        playerRepository = mock(PlayerRepositoryImpl.class);
        playerService = new PlayerServiceImpl(playerRepository);
    }
    */

    @Test
    public void testFindAll() {
        // Given
        //PlayerRepositoryImpl playerRepository = mock(PlayerRepositoryImpl.class); //simulación del objeto PlayerRepositoryImpl
        //PlayerServiceImpl playerService = new PlayerServiceImpl(playerRepository);

        // When
        when(playerRepository.findAll()).thenReturn(DataProvider.playerListMock());
        List<Player> resultado = playerService.findAll();

        // Then
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertEquals("Lionel Messi", resultado.get(0).getName());
        assertEquals("Inter Miami", resultado.get(0).getTeam());
        assertEquals("Delantero", resultado.get(0).getPosition());

        verify(playerRepository).findAll(); //verifica la dependencia
    }

    @Test
    public void testFindById() {
        // Given
        Long id = 1L;

        // When
        when(playerRepository.findById( anyLong() )).thenReturn(DataProvider.playerMock());
        Player player = playerService.findById(id);

        // Then
        assertNotNull(player);
        assertEquals("Lionel Messi", player.getName());
        assertEquals("Inter Miami", player.getTeam());
        assertEquals("Delantero", player.getPosition());

        verify(playerRepository).findById( anyLong() ); //verifica la dependencia
    }

    @Test
    public void testSave() {
        // Given
        Player player = DataProvider.newPlayerMock();

        // When
        playerService.save(player);

        // Then
        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(playerRepository).save( any(Player.class) );
        verify(playerRepository).save( playerArgumentCaptor.capture() ); //verifica que se llame al método con la captura del player
        assertEquals(10L, playerArgumentCaptor.getValue().getId());
        assertEquals("Luis Diaz", playerArgumentCaptor.getValue().getName());
    }

    @Test
    public void testById() {
        // Given
        Long id = 1L;

        // When
        playerService.deleteById(id);

        // Then
        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(playerRepository).deleteById( anyLong() ); //verifica que se llame al método con cualquier Long
        verify(playerRepository).deleteById( longArgumentCaptor.capture() );
        assertEquals(1L, longArgumentCaptor.getValue());

    }

}
