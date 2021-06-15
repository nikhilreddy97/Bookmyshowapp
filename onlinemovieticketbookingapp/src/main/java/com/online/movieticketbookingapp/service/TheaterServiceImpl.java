package com.online.movieticketbookingapp.service;

import com.online.movieticketbookingapp.dto.TheaterCreateDto;
import com.online.movieticketbookingapp.entity.Address;
import com.online.movieticketbookingapp.entity.Movie;
import com.online.movieticketbookingapp.entity.Screens;
import com.online.movieticketbookingapp.entity.Theater;
import com.online.movieticketbookingapp.exceptions.MovieDetailsException;
import com.online.movieticketbookingapp.exceptions.TheaterDetailsException;
import com.online.movieticketbookingapp.repository.AddressRepositoty;
import com.online.movieticketbookingapp.repository.MovieRepository;
import com.online.movieticketbookingapp.repository.TheaterRepository;
import com.online.movieticketbookingapp.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    AddressRepositoty addressRepositoty;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void createTheater(TheaterCreateDto theaterdto) throws Exception {

        String movieName = theaterdto.getMovieName();
        Optional<Movie> movieReponse = movieRepository.findByMovieName(movieName);
        if(!movieReponse.isPresent()){
            throw new MovieDetailsException("Movie Details not found");
        }
        Theater theater = new Theater();
        theater.setTheaterName(theaterdto.getTheaterName());
        theater.setStatus(theaterdto.getStatus());
        //screen details set
        Screens screens = new Screens();
        screens.setDate(theaterdto.getDate());
        screens.setMovieName(theaterdto.getMovieName());
        screens.setScreenName(theaterdto.getScreenName());
        screens.setTheaterName(theaterdto.getTheaterName());
        screens.setScreenStatus(theaterdto.getScreenStatus());
        screens.setNoOfRows(theaterdto.getNoOfRows());
        screens.setNoOfSeats(theaterdto.getNoOfSeats());
        screens.setShowEndTime(theaterdto.getShowEndTime());
        screens.setShowStartTime(theaterdto.getShowStartTime());
        screens.setTotalSeats(theaterdto.getTotalSeats());
        //address details set
        Address address = new Address();
        address.setState(theaterdto.getState());
        address.setPincode(theaterdto.getPincode());
        address.setArea(theaterdto.getArea());
        address.setCity(theaterdto.getCity());
        address.setStreetNo(theaterdto.getStreetNo());
        address.setTheaters(theater);

        theater.setMovie(movieReponse.get());
        theater.setAddresses(address);
        theater.setScreens(screens);
        Theater theaterResponse = theaterRepository.save(theater);
        if (theaterResponse == null) {
            throw new Exception("Details not saved");
        }
    }

    @Override
    public List<Address> getAllTheatersByCityAndMovie(String cityName, String movieName) throws TheaterDetailsException {
        List<Address> addressList = addressRepositoty.findByCity(cityName)
                .stream().filter(movie -> movie.getTheaters().getMovie().getMovieName().equals(movieName))
                .collect(Collectors.toList());

        if (addressList == null || addressList.isEmpty()) {
            throw new TheaterDetailsException("Theater Details not found with " +movieName);
        }
        return addressList;
    }

    @Override
    public Theater getTheaterDetails(String theaterName) throws TheaterDetailsException {
        Optional<Theater> response = theaterRepository.findByTheaterName(theaterName);
        if (!response.isPresent()) {
            throw new TheaterDetailsException("Theater Details not found with " +theaterName);
        }
        Constants.SCREEN_ID = response.get().getScreens().getScreenId();
        Constants.THEATER_NAME = response.get().getTheaterName();
        return response.get();
    }
}
