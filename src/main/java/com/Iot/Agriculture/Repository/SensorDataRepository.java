package com.Iot.Agriculture.Repository;

import com.Iot.Agriculture.Model.UserSensorDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository  extends JpaRepository<UserSensorDataModel,Integer> {
}
