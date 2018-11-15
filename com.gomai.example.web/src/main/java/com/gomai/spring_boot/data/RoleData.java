package com.gomai.spring_boot.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "S_ROLE")
public class RoleData implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 1678805185837052414L;

	@Id
	@Column(name = "ID", length = 32, nullable = false)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESC")
	private String desc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public RoleData(String id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	public RoleData() {
		super();
	}

	@Override
	public String toString() {
		return "RoleData [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

}
