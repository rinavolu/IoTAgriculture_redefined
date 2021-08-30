package com.Iot.Agriculture.Repository;

import com.Iot.Agriculture.Model.UserRegistrationDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationDataRepository extends JpaRepository<UserRegistrationDataModel,Integer> {
}
