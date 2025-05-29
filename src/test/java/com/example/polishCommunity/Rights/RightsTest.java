//package com.example.polishCommunity.Rights;
//
//import com.example.polishCommunity.model.Rights;
//import com.example.polishCommunity.model.RightsFAQs;
//import com.example.polishCommunity.model.SubRights;
//import com.example.polishCommunity.repository.RightsRepo;
//


//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.jdbc.core.JdbcTemplate;


//import org.springframework.jdbc.core.RowMapper;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//
//public class RightsTest {
//
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    private RightsRepo rightsRepo;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        rightsRepo = new RightsRepo(jdbcTemplate);
//    }
//
//    @Test
//    public void testGetRightsById_Success() {
//        // Prepare mock data
//        Rights mockRights = new Rights(1, "Sample Rights", "Description of rights");
//
//        // Simulate JdbcTemplate behavior
//        String sql = "select * from rights where title_id = ?";
//        when(jdbcTemplate.queryForObject(eq(sql), any(RowMapper.class), eq(1))).thenReturn(mockRights);
//
//        // Call the method
//        Rights result = rightsRepo.getRightsById(1);
//
//        // Verify interactions
//        verify(jdbcTemplate).queryForObject(eq(sql), any(RowMapper.class), eq(1));
//
//        // Assert the result
//        assertNotNull(result);
//        assertEquals(mockRights, result);
//    }
//
//    @Test
//    public void testGetSubRightsByRightsId_Success() {
//        // Prepare mock data
//        SubRights mockSubRights1 = new SubRights(1, "SubRight 1", "Description 1", 1);
//        SubRights mockSubRights2 = new SubRights(2, "SubRight 2", "Description 2", 1);
//        List<SubRights> mockSubRightsList = Arrays.asList(mockSubRights1, mockSubRights2);
//
//        // Simulate JdbcTemplate behavior
//        String sql = "select * from sub_rights where title_id =?";
//        when(jdbcTemplate.query(eq(sql), any(RowMapper.class), eq(1))).thenReturn(mockSubRightsList);
//
//        // Call the method
//        List<SubRights> result = rightsRepo.getSubRightsByRightsId(1);
//
//        // Verify interactions
//        verify(jdbcTemplate).query(eq(sql), any(RowMapper.class), eq(1));
//
//        // Assert the result
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertTrue(result.containsAll(mockSubRightsList));
//    }
//
//    @Test
//    public void testAddSubRight_Success() {
//        // Prepare data
//        SubRights subRights = new SubRights(3, "New SubRight", "New description", 1);
//
//        // Simulate JdbcTemplate behavior
//        String sql = "INSERT INTO sub_rights (sub_title, description, title_id) VALUES (?, ?, ?)";
//        doNothing().when(jdbcTemplate).update(eq(sql), eq(subRights.getSubTitle()), eq(subRights.getDescription()), eq(subRights.getTitleId()));
//
//        // Call the method
//        rightsRepo.addSubRight(subRights);
//
//        // Verify interactions
//        verify(jdbcTemplate).update(eq(sql), eq(subRights.getSubTitle()), eq(subRights.getDescription()), eq(subRights.getTitleId()));
//    }
//
//    @Test
//    public void testGetRightsFAQsByRightsId_Success() {
//        // Prepare mock data
//        RightsFAQs mockFAQ1 = new RightsFAQs(1, "What is this?", "This is a sample FAQ.", 1);
//        RightsFAQs mockFAQ2 = new RightsFAQs(2, "How does this work?", "Explanation of how it works.", 1);
//        List<RightsFAQs> mockFAQList = Arrays.asList(mockFAQ1, mockFAQ2);
//
//        // Simulate JdbcTemplate behavior
//        String sql = "select * from rights_FAQs where title_id =?";
//        when(jdbcTemplate.query(eq(sql), any(RowMapper.class), eq(1))).thenReturn(mockFAQList);
//
//        // Call the method
//        List<RightsFAQs> result = rightsRepo.getRightsFAQsByRightsId(1);
//
//        // Verify interactions
//        verify(jdbcTemplate).query(eq(sql), any(RowMapper.class), eq(1));
//
//        // Assert the result
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertTrue(result.containsAll(mockFAQList));
//    }
//}
