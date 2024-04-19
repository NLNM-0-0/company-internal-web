package com.ciw.backend.entity;

import com.ciw.backend.payload.post.PostAttachment;
import com.ciw.backend.utils.converter.HashMapConverter;
import com.ciw.backend.utils.converter.ListConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
		name = "post"
)
@EntityListeners(AuditingEntityListener.class)
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Length(min = 1, max = 100)
	private String title;

	@Column(nullable = false)
	@Length(min = 0, max = 200)
	private String description;

	@Convert(converter = HashMapConverter.class)
	@Column(columnDefinition = "text")
	private Map<String, Object> content;

	@Column(nullable = false)
	private String image;

	@Convert(converter = PostAttachmentConverter.class)
	@Column(columnDefinition = "text")
	private List<PostAttachment> attachments;

	@ManyToOne
	@JoinColumn(name = "created_by", nullable = false, updatable = false)
	@CreatedBy
	private User createdBy;

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name = "post_tag",
			joinColumns = @JoinColumn(name = "post_id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags;
}

class PostAttachmentConverter extends ListConverter<PostAttachment> {
	public PostAttachmentConverter(ObjectMapper objectMapper) {
		super(objectMapper);
	}
}