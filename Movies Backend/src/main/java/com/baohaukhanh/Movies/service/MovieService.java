package com.baohaukhanh.Movies.service;

import com.baohaukhanh.Movies.dto.MovieDTO;
import com.baohaukhanh.Movies.dto.MovieSummaryDTO;

import java.util.List;

public interface MovieService {
    
    /**
     * Lấy tất cả phim (chỉ thông tin cơ bản)
     * @return danh sách phim với thông tin tóm tắt
     */
    List<MovieSummaryDTO> getAllMovies();
    
    /**
     * Lấy chi tiết phim theo ID
     * @param id ID của phim
     * @return thông tin chi tiết của phim
     */
    MovieDTO getMovieById(Long id);
    
    /**
     * Tìm kiếm phim theo tên
     * @param title tên phim
     * @return danh sách phim tìm được
     */
    List<MovieSummaryDTO> searchMoviesByTitle(String title);
}

