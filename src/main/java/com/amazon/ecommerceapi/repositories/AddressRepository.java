package com.amazon.ecommerceapi.repositories;

import com.amazon.ecommerceapi.domain.Account;
import com.amazon.ecommerceapi.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sun.jvm.hotspot.debugger.Page;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByAccountId(Integer accountId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Address a WHERE a.account = :account AND a.id = :addressId")
    void deleteAddressByAccountAndId(@Param("account") Account account, @Param("addressId") Integer addressId);

    //@Query("SELECT a FROM Address a WHERE a.account = :account AND a.id = :addressId")
    Address findAddressByAccountAndId(@Param("account") Account account, @Param("addressId") Integer addressId);



}
