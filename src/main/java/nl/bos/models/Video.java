package nl.bos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Video {
	@Id
	@GeneratedValue
	private final long id;

	@Column(nullable = false)
	@NotNull
	private final String title;

	@Column(nullable = false)
	@NotNull
	private final String description;

	@Column(nullable = false)
	@NotNull
	private final String youTubeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = false)
	@JsonBackReference
	private final Product product;

	public Video() {
		this.title = "";
		this.description = "";
		this.youTubeId = "";
		this.product = null;
		this.id = 0;
	}

	public Video(String title, String description, String youTubeId, Product product) {
		this.id = -1;
		this.title = title;
		this.description = description;
		this.youTubeId = youTubeId;
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getYouTubeId() {
		return youTubeId;
	}

	public Product getProduct() {
		return product;
	}
}
