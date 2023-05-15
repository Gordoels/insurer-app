package com.insurer.app.insurance.test;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;
import com.insurer.app.car.service.CarService;
import com.insurer.app.customer.model.Customer;
import com.insurer.app.customer.repository.CustomerRepository;
import com.insurer.app.customer.service.CustomerService;
import com.insurer.app.driver.model.Driver;
import com.insurer.app.driver.repository.DriverRepository;
import com.insurer.app.driver.service.DriverService;
import com.insurer.app.insurance.repository.InsuranceRepository;
import com.insurer.app.insurance.service.InsuranceService;

@DataJpaTest
public class InsuranceIntegrationTest {
    
    @Mock
    private InsuranceRepository insuranceRepository;
    
    @Mock
    private CarRepository carRepository;
    
    @Mock
    private DriverRepository driverRepository;
    
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private InsuranceService insuranceService;
    
    @InjectMocks
    CarService carService;
    
    @InjectMocks
    DriverService driverService;
    
    @InjectMocks
    CustomerService customerService;
    
    private static Car car;
    private static Customer customer;
    private static Driver driver;

    @BeforeAll
    public static void mockSetup() {
        car = new Car();
        car.setCarId(1L);
        car.setCarModel("Model X");
        car.setCarManufacturer("Tesla");
        car.setCarYear(2022);
        car.setFipeValue(10000.0);
        car.setHasClaim(false);
        
        driver = new Driver();
        driver.setDriverId(1L);
        driver.setBirthdate(LocalDate.of(1995, 12, 5));
        driver.setDocument("123456789");
        driver.setHasClaim(false);
        
        customer = new Customer();
        customer.setCustomerId(1L);
        customer.setName("John");
        customer.setDriver(driver);
        
    }

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testInsurancePersistence() {
//
//        entityManager.persistAndFlush(car);
//        entityManager.persistAndFlush(driver);
//        entityManager.persistAndFlush(customer);
//
//        
//        Insurance insurance = new Insurance();
//        insurance.setCar(car);
//        insurance.setCustomer(customer);
//        insurance.setInsuranceBudget(600.0);
//
//        Insurance savedInsurance = entityManager.persistAndFlush(insurance);
//
//        
//        assertNotNull(savedInsurance.getInsuranceId());
//        assertEquals(car.getCarId(), savedInsurance.getCar().getCarId());
//        assertEquals(customer.getCustomerId(), savedInsurance.getCustomer().getCustomerId());
//        assertEquals(600.0, savedInsurance.getInsuranceBudget());
//    }
    
//    @Test
//    public void testCreateInsuranceService() { 
//    	
//    	Insurance insurance = new Insurance();
//        insurance.setInsuranceId(1L);
//        insurance.setCar(car);
//        insurance.setCustomer(customer);
//        
//        when(carRepository.save(car)).thenReturn(car);
//        when(driverRepository.save(driver)).thenReturn(driver);
//        when(customerRepository.save(customer)).thenReturn(customer);
//        when(insuranceRepository.save(insurance)).thenReturn(insurance);
//        
//        
//        when(carRepository.findById(anyLong())).thenReturn(Optional.of(car));
//        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
//       
//        Insurance createdInsurance = insuranceService.createInsurance(insurance);
//
//        verify(insuranceRepository, times(1)).save(insurance);
//
//        assertEquals(insurance, createdInsurance);
//    }
}

