package com.Iot.Agriculture.Repository;

import com.Iot.Agriculture.Model.UserDeviceDetailsDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDeviceDataRepository extends JpaRepository<UserDeviceDetailsDataModel, Integer> {
}
