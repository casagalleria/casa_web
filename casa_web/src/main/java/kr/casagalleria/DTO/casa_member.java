package kr.casagalleria.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class casa_member {
	@Id
	@Column(name="usr_no")
	private String no;
	@Column(name="usr_uuid")
	private String uuid;
	@Column(name="usr_id")
	private String id;
	@Column(name="usr_type")
	private int type;
	@Column(name="usr_name")
	private String name;
	@Column(name="usr_pw")
	private String pw;
	@Column(name="usr_insertdate")
	private Date insertdate;
	@Column(name="usr_update")
	private Date update;
}
