package com.ibm.mics.sql.mapper;

import org.apache.ibatis.annotations.*;

import com.ibm.mics.entity.util.*;

public interface MadicalCareMapper {
	
	@Insert("INSERT INTO medicalcare(kind,fanwei,payment,patientName) VALUES(#{medicalcare.kind},#{medicalcare.range},#{medicalcare.payment},#{medicalcare.patientName})")
	void insertomedical(@Param("medicalcare") MedicalCare medicalcare);

}
