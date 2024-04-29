package com.ciw.backend.entity;

import com.ciw.backend.payload.calendar.ShiftType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
		name = "unit_shift_absent",
		uniqueConstraints = {
				@UniqueConstraint(
						columnNames = {"date", "shift_type", "unit_id"},
						name = "Bảng ghi"
				)
		}
)
@EntityListeners(AuditingEntityListener.class)
public class UnitShiftAbsent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(
			targetEntity = Unit.class,
			fetch = FetchType.LAZY
	)
	@JoinColumn(
			name = "unit_id",
			nullable = false
	)
	private Unit unit;

	@Column(nullable = false)
	private Date date;

	@Enumerated(EnumType.STRING)
	@Column(
			name = "shift_type",
			nullable = false
	)
	private ShiftType shiftType;

	@ManyToOne
	@JoinColumn(
			name = "created_by",
			nullable = false,
			updatable = false
	)
	@CreatedBy
	private User createdBy;
}
