package pt.com.travelApp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "request_log")
@EntityListeners(AuditingEntityListener.class)
public class RequestLog implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name = "id_product")
    private Long id;
	
	@Column(name = "ds_url_request")
	private String urlRequest;
	
	@Column(name = "ds_response", columnDefinition = "json")
	private String response;
	
	@Column(name = "dt_created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlRequest() {
		return urlRequest;
	}

	public void setUrlRequest(String urlRequest) {
		this.urlRequest = urlRequest;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
