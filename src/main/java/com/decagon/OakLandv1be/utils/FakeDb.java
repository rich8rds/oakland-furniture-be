package com.decagon.OakLandv1be.utils;

import com.decagon.OakLandv1be.entities.*;
import com.decagon.OakLandv1be.enums.BaseCurrency;
import com.decagon.OakLandv1be.enums.Gender;
import com.decagon.OakLandv1be.enums.Role;
import com.decagon.OakLandv1be.exceptions.NotAvailableException;
import com.decagon.OakLandv1be.exceptions.ProductNotFoundException;
import com.decagon.OakLandv1be.repositries.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class FakeDb {

    private final PasswordEncoder passwordEncoder;

    private final StateRepository stateRepository;
    private final PickupRepository pickupRepository;

    private final AdminRepository adminRepository;



    @Bean
    @Qualifier("MyOtherCommand")
    public CommandLineRunner myCommandLineRunner(PersonRepository personRepository,

                                                 ProductRepository productRepository,
                                                 CustomerRepository customerRepository,
                                                 SubCategoryRepository subCategoryRepository,
                                                 CategoryRepository categoryRepository) {
        return argument -> {
            if (!personRepository.existsByEmail("bennyson1@gmail.com")) {
                Admin admin = new Admin();
                Person person = Person.builder()
                        .firstName("Benson")
                        .lastName("Malik")
                        .email("bennyson1@gmail.com")
                        .gender(Gender.MALE)
                        .date_of_birth("13-08-1990")
                        .phone("9859595959")
                        .isActive(true)
                        .admin(admin)
                        .verificationStatus(true)
                        .admin(admin)
                        .address("No Address")
                        .role(Role.ADMIN)
                        .password(passwordEncoder.encode("password123453"))
                        .isActive(true)
                        .build();

                Person adminPerson = personRepository.save(person);
                admin.setPerson(adminPerson);
                Admin savedAdmin = adminRepository.save(admin);

                Customer customer = new Customer();
                Person customerPerson = Person.builder()
                        .firstName("Joe")
                        .lastName("Lennon")
                        .email("bennyson2@gmail.com")
                        .gender(Gender.MALE)
                        .date_of_birth("1996-03-12")
                        .phone("9859595959")
                        .isActive(true)
                        .verificationStatus(true)
                        .role(Role.CUSTOMER)
                        .customer(customer)
                        .address("No Address")
                        .password(passwordEncoder.encode("password123453"))
                        .isActive(true)

                        .build();
                Person savedPerson = personRepository.save(customerPerson);
                customer.setPerson(savedPerson);
                customerRepository.save(customer);

                Customer customer1 = new Customer();
                Person person1 = Person.builder()
                        .firstName("Alex")
                        .lastName("Cole")
                        .email("indigo@gmail.com")
                        .gender(Gender.MALE)
                        .date_of_birth("13-08-1990")
                        .phone("9859595959")
                        .isActive(true)
                        .customer(customer1)
                        .verificationStatus(true)
                        .address("No Address")
                        .role(Role.ADMIN)
                        .password(passwordEncoder.encode("password123453"))
                        .isActive(true)

                        .build();
                Person savedperson1 = personRepository.save(person1);

                customer1.setPerson(person1);

                Wallet wallet = Wallet.builder()
                        .baseCurrency(BaseCurrency.NAIRA)
                        .accountBalance(BigDecimal.valueOf(400000))
                        .build();

                customer1.setPerson(savedperson1);
                customer1.setWallet(wallet);
                customerRepository.save(customer1);


                Customer customer2 = new Customer();
                Person person2 = Person.builder()
                        .firstName("Natalie")
                        .lastName("Feshman")
                        .email("oppenheimer@gmail.com")
                        .gender(Gender.MALE)
                        .date_of_birth("13-08-1990")
                        .phone("9859595959")
                        .isActive(true)
                        .customer(customer2)
                        .verificationStatus(true)
                        .address("No Address")
                        .role(Role.ADMIN)
                        .password(passwordEncoder.encode("password123453"))
                        .isActive(true)

                        .build();
                Person savedperson2 = personRepository.save(person2);

                customer1.setPerson(person2);

                Wallet wallet1 = Wallet.builder()
                        .baseCurrency(BaseCurrency.NAIRA)
                        .accountBalance(BigDecimal.valueOf(400000))
                        .build();

                customer2.setPerson(savedperson2);
                customer2.setWallet(wallet1);
                customerRepository.save(customer2);


                Customer customer3 = new Customer();
                Person person3 = Person.builder()
                        .firstName("Natalie")
                        .lastName("Feshman")
                        .email("natialieFreshman@gmail.com")
                        .gender(Gender.MALE)
                        .date_of_birth("13-08-1990")
                        .phone("9859595959")
                        .isActive(true)
                        .customer(customer3)
                        .verificationStatus(true)
                        .address("No Address")
                        .role(Role.ADMIN)
                        .password(passwordEncoder.encode("password123453"))
                        .isActive(true)

                        .build();
                Person savedperson3 = personRepository.save(person3);

                customer3.setPerson(person3);

                Wallet wallet2 = Wallet.builder()
                        .baseCurrency(BaseCurrency.NAIRA)
                        .accountBalance(BigDecimal.valueOf(400000))
                        .build();

                customer3.setPerson(savedperson3);
                customer3.setWallet(wallet2);
                customerRepository.save(customer3);


                Customer customer4 = new Customer();
                Person person4 = Person.builder()
                        .firstName("King")
                        .lastName("Kong")
                        .email("kingKong@gmail.com")
                        .gender(Gender.MALE)
                        .date_of_birth("13-08-1990")
                        .phone("9859595959")
                        .isActive(true)
                        .customer(customer4)
                        .verificationStatus(true)
                        .address("No Address")
                        .role(Role.ADMIN)
                        .password(passwordEncoder.encode("password123453"))
                        .isActive(true)

                        .build();
                Person savedperson4 = personRepository.save(person4);

                customer1.setPerson(person4);

                Wallet wallet3 = Wallet.builder()
                        .baseCurrency(BaseCurrency.NAIRA)
                        .accountBalance(BigDecimal.valueOf(400000))
                        .build();

                customer4.setPerson(savedperson4);
                customer4.setWallet(wallet3);
                customerRepository.save(customer4);
            }

            if(!stateRepository.existsById(1L)) {
                State lagos = State.builder()
                        .name("Lagos")
                        .build();
                State kwara = State.builder()
                        .name("Kwara")
                        .build();
                State anambra = State.builder()
                        .name("Anambra")
                        .build();
                State osun = State.builder()
                        .name("Osun")
                        .build();
                State akwaibom = State.builder()
                        .name("AkwaIbom")
                        .build();
                State kano = State.builder()
                        .name("Kano")
                        .build();
                List<State> states = List.of(lagos, kwara, anambra, osun, akwaibom, kano);
                stateRepository.saveAll(states);
            }

            if(!pickupRepository.existsById(1L)) {
                State lagos = stateRepository.findById(1L).orElseThrow(() -> new NotAvailableException("State not found"));
                State kwara = stateRepository.findById(2L).orElseThrow(() -> new NotAvailableException("State not found"));
                State anambra = stateRepository.findById(3L).orElseThrow(() -> new NotAvailableException("State not found"));
                State osun = stateRepository.findById(4L).orElseThrow(() -> new NotAvailableException("State not found"));
                State akwaibom = stateRepository.findById(5L).orElseThrow(() -> new NotAvailableException("State not found"));
                State kano = stateRepository.findById(6L).orElseThrow(() -> new NotAvailableException("State not found"));

                PickupCenter lagosPickup = PickupCenter.builder()
                        .name("Lagos Pickup Center")
                        .state(lagos)
                        .email("lagospickup@oakland.com")
                        .phone("09033444123")
                        .address("12 Ibom Street, Allen, Ikeja, Lagos")
                        .build();

                PickupCenter lagosPickup2 = PickupCenter.builder()
                        .name("2nd Lagos Pickup Center")
                        .state(lagos)
                        .email("lagospickuptwo@oakland.com")
                        .phone("09033444111")
                        .address("1 Aka Street, Allen, Oshodi, Lagos")
                        .build();

                PickupCenter kwaraPickup = PickupCenter.builder()
                        .name("Kwara Pickup Center")
                        .state(kwara)
                        .email("kwarapickup@oakland.com")
                        .phone("08022444123")
                        .address("13 Ibom Street, Allen, Kwara")
                        .build();

                PickupCenter anambraPickup = PickupCenter.builder()
                        .name("Anambra Pickup Center")
                        .state(anambra)
                        .email("anambrapickup@oakland.com")
                        .phone("09011444123")
                        .address("14 Ibom Street, Allen, Nnewi, Anmabra")
                        .build();

                PickupCenter osunPickup = PickupCenter.builder()
                        .name("Osun Pickup Center")
                        .state(osun)
                        .email("osunpickup@oakland.com")
                        .phone("08000444123")
                        .address("15 Ibom Street, Oshogbo, Osun")
                        .build();

                PickupCenter akwaIbomPickup = PickupCenter.builder()
                        .name("AkwaIbom Pickup Center")
                        .state(akwaibom)
                        .email("akwaibompickup@oakland.com")
                        .phone("09055444123")
                        .address("16 Ibom Street, AkwaIbom")
                        .build();

                PickupCenter kanoPickup = PickupCenter.builder()
                        .name("Kano Pickup Center")
                        .state(kano)
                        .email("kanopickup@oakland.com")
                        .phone("08133444123")
                        .address("12 Ibom Street, kano, Kano")
                        .build();

                List<PickupCenter> pickupCenters = List.of(lagosPickup, lagosPickup2, kwaraPickup, anambraPickup, osunPickup, akwaIbomPickup, kanoPickup);
                pickupRepository.saveAll(pickupCenters);
            }

            if (!categoryRepository.existsById(1L)) {

                Category table = Category.builder()
                        .name("Table")
                        .build();
                Category chair = Category.builder()
                        .name("Chair")
                        .build();
                Category cupboard = Category.builder()
                        .name("Cupboard")
                        .build();
                Category sofa = Category.builder()
                        .name("Sofa")
                        .build();
                Category dresser = Category.builder()
                        .name("Dresser")
                        .build();
                Category modern = Category.builder()
                        .name("Modern")
                        .build();
                Category lamps = Category.builder()
                        .name("Lamps")
                        .build();
                Category wooden = Category.builder()
                        .name("Wooden")
                        .build();
                List<Category> categories = List.of(table, sofa, cupboard, chair, dresser, modern, lamps, wooden);
                categoryRepository.saveAll(categories);
            }

            if (!subCategoryRepository.existsById(1L)) {
                Category table = categoryRepository.findById(1L).orElseThrow(() -> new ProductNotFoundException("Not found!"));
                Category sofa = categoryRepository.findById(2L).orElseThrow(() -> new ProductNotFoundException("Not found!"));
                Category cupboard = categoryRepository.findById(3L).orElseThrow(() -> new ProductNotFoundException("Not found!"));
                Category chair = categoryRepository.findById(4L).orElseThrow(() -> new ProductNotFoundException("Not found!"));
                Category dresser = categoryRepository.findById(5L).orElseThrow(() -> new ProductNotFoundException("Not found!"));
                Category modern = categoryRepository.findById(6L).orElseThrow(() -> new ProductNotFoundException("Not found!"));
                Category lamps = categoryRepository.findById(7L).orElseThrow(() -> new ProductNotFoundException("Not found!"));
                Category wooden = categoryRepository.findById(8L).orElseThrow(() -> new ProductNotFoundException("Not found!"));

                SubCategory lamp2 = SubCategory.builder()
                        .name("Coffee Lamp")
                        .category(lamps)
                        .build();
                SubCategory lamp1 = SubCategory.builder()
                        .name("Nighty Lamp")
                        .category(lamps)
                        .build();
                SubCategory lamp3 = SubCategory.builder()
                        .name("Work Lamp")
                        .category(lamps)
                        .build();

                SubCategory table4 = SubCategory.builder()
                        .name("Oak Table")
                        .category(table)
                        .build();
                SubCategory table3 = SubCategory.builder()
                        .name("Dining Table")
                        .category(table)
                        .build();
                SubCategory table2 = SubCategory.builder()
                        .name("Work Table")
                        .category(table)
                        .build();
                SubCategory table1 = SubCategory.builder()
                        .name("Chief Table")
                        .category(table)
                        .build();
                SubCategory chair2 = SubCategory.builder()
                        .name("Work Chair")
                        .category(chair)
                        .build();
                SubCategory chair1 = SubCategory.builder()
                        .name("Sofa Chair")
                        .category(chair)
                        .build();
                SubCategory wooden2 = SubCategory.builder()
                        .name("Sheriff Wood")
                        .category(wooden)
                        .build();
                SubCategory wooden3 = SubCategory.builder()
                        .name("Table Wood")
                        .category(wooden)
                        .build();
                SubCategory wooden1 = SubCategory.builder()
                        .name("Wooden Rack")
                        .category(wooden)
                        .build();
                SubCategory modern2 = SubCategory.builder()
                        .name("Upperside Chair")
                        .category(modern)
                        .build();
                SubCategory modern1 = SubCategory.builder()
                        .name("Minty Fresh Chair")
                        .category(modern)
                        .build();
                SubCategory modern4 = SubCategory.builder()
                        .name("Top Table")
                        .category(modern)
                        .build();
                SubCategory modern3 = SubCategory.builder()
                        .name("High Lifting Cupboard")
                        .category(modern)
                        .build();
                SubCategory sofa3 = SubCategory.builder()
                        .name("Home Sofa")
                        .category(sofa)
                        .build();
                SubCategory sofa2 = SubCategory.builder()
                        .name("Work Sofa")
                        .category(sofa)
                        .build();
                SubCategory sofa1 = SubCategory.builder()
                        .name("Living Room Sofa")
                        .category(sofa)
                        .build();
                SubCategory cupboard1 = SubCategory.builder()
                        .name("Dresser")
                        .category(cupboard)
                        .build();
                SubCategory cupboard2 = SubCategory.builder()
                        .name("6ft Cupboard")
                        .category(cupboard)
                        .build();
                SubCategory dresser4 = SubCategory.builder()
                        .name("BK Dresser")
                        .category(dresser)
                        .build();
                SubCategory dresser3 = SubCategory.builder()
                        .name("Upperside Dresser")
                        .category(dresser)
                        .build();
                SubCategory dresser2 = SubCategory.builder()
                        .name("Minty Fresh Dresser")
                        .category(dresser)
                        .build();
                SubCategory dresser1 = SubCategory.builder()
                        .name("Top Dresser")
                        .category(dresser)
                        .build();
                List<SubCategory> subCategories = List.of(
                        table1, table2, table3, table4,
                        wooden2, wooden1, wooden3,
                        sofa1, sofa2, sofa3,
                        cupboard1, cupboard2,
                        chair1, chair2,
                        modern1, modern2, modern3, modern4,
                        dresser1, dresser2, dresser3, dresser4,
                        lamp1, lamp2, lamp3
                );


                subCategoryRepository.saveAll(subCategories);


            }

            if (!productRepository.existsById(1L)) {

                SubCategory table1 = subCategoryRepository.findById(1L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory table2 = subCategoryRepository.findById(2L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory table3 = subCategoryRepository.findById(3L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory table4 = subCategoryRepository.findById(4L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory wooden2 = subCategoryRepository.findById(5L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory wooden1 = subCategoryRepository.findById(6L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));

                SubCategory wooden3 = subCategoryRepository.findById(7L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory sofa1 = subCategoryRepository.findById(8L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));

                SubCategory sofa2 = subCategoryRepository.findById(9L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory sofa3 = subCategoryRepository.findById(10L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory cupboard1 = subCategoryRepository.findById(11L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));

                SubCategory cupboard2 = subCategoryRepository.findById(12L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory chair1 = subCategoryRepository.findById(13L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));

                SubCategory chair2 = subCategoryRepository.findById(14L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory modern1 = subCategoryRepository.findById(15L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));

                SubCategory modern2 = subCategoryRepository.findById(16L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));

                SubCategory modern3 = subCategoryRepository.findById(17L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory modern4 = subCategoryRepository.findById(18L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory dresser1 = subCategoryRepository.findById(19L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory dresser2 = subCategoryRepository.findById(20L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));

                SubCategory dresser3 = subCategoryRepository.findById(21L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory dresser4 = subCategoryRepository.findById(22L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory lamp1 = subCategoryRepository.findById(23L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory lamp2 = subCategoryRepository.findById(24L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));
                SubCategory lamp3 = subCategoryRepository.findById(25L).orElseThrow(() -> new ProductNotFoundException("Category not found!"));


                List<Product> products = List.of(
                        Product.builder()
                                .name("SHELVES WOOD")
                                .price(40000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-U5BW8PS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(lamp1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("TABLE WOOD")
                                .price(10000.00)
                                .availableQty(20)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/RBSJBF@2x.jpg")
                                .color("brown")
                                .subCategory(lamp2)
                                .description("lovely furnished Lorem Ipsum")
                                .build(),
                        Product.builder()
                                .name("WOODEN RACK")
                                .price(50000.00)
                                .availableQty(100)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-92DNEPD@2x-300x300.jpg")
                                .color("sunset yellow")
                                .subCategory(lamp3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("COFFEE TABLE")
                                .price(20000.00)
                                .availableQty(440)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/J7ZW2XK@2x-300x300.jpg")
                                .color("gray")
                                .subCategory(modern1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("END TABLE")
                                .price(40000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-RBSJBF@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(modern2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("MODERN TABLE")
                                .price(41000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Group-1@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(modern3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("TABLE WOOD")
                                .price(42000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/3N8FQJ@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(chair1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("LOUNGE SOFA")
                                .price(43000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/JD46ETY@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(chair2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("LUXURY SOFA")
                                .price(44000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/4PHLD2@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(dresser4)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("MODERN CHAIR")
                                .price(45000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-WAX664T@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(table4)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("MODERN TABLE")
                                .price(46000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Group-1@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(table3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("DECO LAMP")
                                .price(47000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/XFSNSK@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(modern1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("TABLE LAMP")
                                .price(48000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(sofa1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("SCANDINAVIA DRESSER")
                                .price(49000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/YMN7ZV@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(sofa2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("KALE BED SET")
                                .price(50000.00)
                                .availableQty(400)
                                .imageUrl("https://baffihomeng.com/kale-bed-set-bed-set-1699-11-K.jpg")
                                .color("yellow")
                                .subCategory(sofa3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("ODESSA BED SET")
                                .price(51000.00)
                                .availableQty(400)
                                .imageUrl("https://baffihomeng.com/odessa-bed-set-with-wardrobe-bed-set-2035-39-K.jpg")
                                .color("yellow")
                                .subCategory(cupboard1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("ARM CHAIR")
                                .price(52000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Armc.png")
                                .color("yellow")
                                .subCategory(cupboard2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("LAMP STAND TALL")
                                .price(53000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/KKKVHW.png")
                                .color("yellow")
                                .subCategory(dresser2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("MODERN SOFA SET")
                                .price(54000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/interior-of-modern-living-room-with-sofa-3-d-rendering-e1606471745983.jpg")
                                .color("yellow")
                                .subCategory(dresser3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("CAPE BED SET")
                                .price(55000.00)
                                .availableQty(400)
                                .imageUrl("https://baffihomeng.com/cape-bed-single-bed-1289-20-K.jpg")
                                .color("yellow")
                                .subCategory(modern4)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("DIVA BED")
                                .price(56000.00)
                                .availableQty(400)
                                .imageUrl("https://baffihomeng.com/diva-bed-single-bed-1291-20-K.jpg")
                                .color("yellow")
                                .subCategory(modern1)
                                .description("lovely fur")
                                .build(),

                        Product.builder()
                                .name("75 FLOOR LAMP")
                                .price(43000.00)
                                .availableQty(400)
                                .imageUrl("https://baffihomeng.com/75-floor-lamp-lamp-1956-36-K.jpg")
                                .color("yellow")
                                .subCategory(modern1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("THROW PILLOW DUVET")
                                .price(44000.00)
                                .availableQty(400)
                                .imageUrl("https://baffihomeng.com/throw-pillow-duvet-mattress-1581-28-K.jpg")
                                .color("yellow")
                                .subCategory(sofa1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("MILANO CENTER TABLE")
                                .price(45000.00)
                                .availableQty(400)
                                .imageUrl("https://baffihomeng.com/milano-4-1-center-table-center-table-1974-37-K.jpg")
                                .color("yellow")
                                .subCategory(chair1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("OFFICE DESK")
                                .price(46000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/1-2-metre-wood-office-desk-white-15445592801377_300x.jpg?v=1592585341")
                                .color("yellow")
                                .subCategory(chair2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("ACCENT CHAIR")
                                .price(47000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/accent-chair-and-ottoman-37623578886387_500x.jpg?v=1655993763")
                                .color("yellow")
                                .subCategory(cupboard2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("MULTI PURPOSE RACK")
                                .price(48000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/multi-functional-table-23029700264128_dd69cf9c-b76d-45e2-adf8-6562b647575c_500x.jpg?v=1663265006")
                                .color("yellow")
                                .subCategory(cupboard1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("COFFE BAR CHAIR")
                                .price(49000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/white-cafe-bar-chair_300x.jpg?v=1667641898")
                                .color("yellow")
                                .subCategory(table4)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("COMPACT COFEE TABLE")
                                .price(50000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/compact-3tier-coffee-table-brown-white-center-table-28967970734272_300x.jpg?v=1625440559")
                                .color("yellow")
                                .subCategory(modern4)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("GLOSS GLASS TABLE")
                                .price(51000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/gloss-glass-coffee-table-white-14875512504417_300x.jpg?v=1587505261")
                                .color("yellow")
                                .subCategory(modern3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("HEXAGON TABLE")
                                .price(52000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/hexagon-coffee-table-30999063724224_300x.jpg?v=1633025760")
                                .color("yellow")
                                .subCategory(modern2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("CONSOLE ROUND MIRROR")
                                .price(53000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/console-with-round-mirror-23289712279744_396x_2135b392-a46d-4081-960e-6d05443fd183_396x.jpg?v=1665228228")
                                .color("yellow")
                                .subCategory(modern1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("TV UNITE CONSOLE")
                                .price(54000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/tv-unite-white-brown-37279583011059_400x.jpg?v=1651183795")
                                .color("yellow")
                                .subCategory(wooden3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("TV UNIT 2 CONSOLE")
                                .price(55000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/tv-unit-40x140-cm-37279519277299_300x.jpg?v=1651182714")
                                .color("yellow")
                                .subCategory(wooden2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("LAMINATE WARDOBE")
                                .price(56000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/laminate-board-wardrobe-30163285311680_500x.jpg?v=1628169186")
                                .color("yellow")
                                .subCategory(wooden1)
                                .description("lovely fur")
                                .build(),

                        Product.builder()
                                .name("TRYSIL WARDROBE")
                                .price(43000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/trysil-wardrobe-with-sliding-doors-14244301511_300x.jpg?v=1586962362")
                                .color("yellow")
                                .subCategory(sofa3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("VANITY CHAIR")
                                .price(44000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/vanity-chair-wood-legs-grey-15598760198241_500x.jpg?v=1594193453")
                                .color("yellow")
                                .subCategory(sofa3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("VANITY TABLE")
                                .price(45000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/andrea-series-vanity-table-black-or-white-684409683988_400x.jpg?v=1587030645")
                                .color("yellow")
                                .subCategory(sofa2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("DRESSING MIRROR WHITE")
                                .price(46000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/blue-and-white-pine-wood-dressing-mirror-with-leather-stool-3628232310853_300x.jpg?v=1587023096")
                                .color("yellow")
                                .subCategory(sofa1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("WARDROBE 2 DOOR")
                                .price(47000.00)
                                .availableQty(400)
                                .imageUrl("https://cdn.shopify.com/s/files/1/1185/9434/products/laminate-board-wardrobe-30163285344448_500x.jpg?v=1628169186")
                                .color("yellow")
                                .subCategory(chair2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("Oppola51")
                                .price(48000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(chair1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("Oppola52")
                                .price(49000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(table4)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("Oppola53")
                                .price(50000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(table3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("Oppola54")
                                .price(51000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(table2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("Oppola55")
                                .price(52000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(table1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("Oppola56")
                                .price(53000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(dresser1)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("Oppola57")
                                .price(54000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(dresser3)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("Oppola58")
                                .price(55000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(dresser2)
                                .description("lovely fur")
                                .build(),
                        Product.builder()
                                .name("Oppola59")
                                .price(56000.00)
                                .availableQty(400)
                                .imageUrl("https://templatekit.jegtheme.com/funiture/wp-content/uploads/sites/18/2020/11/Image-NAM2CS@2x-300x300.jpg")
                                .color("yellow")
                                .subCategory(dresser1)
                                .description("lovely fur")
                                .build()
                );


                productRepository.saveAll(products);
            }

        };
    }
}