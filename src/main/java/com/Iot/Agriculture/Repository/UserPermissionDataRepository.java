package com.Iot.Agriculture.Repository;

import com.Iot.Agriculture.Model.UserPermissionDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPermissionDataRepository extends JpaRepository<UserPermissionDataModel,Integer> {
}
