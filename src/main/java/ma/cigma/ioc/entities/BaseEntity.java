package ma.cigma.ioc.entities;


import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    protected String id;

    @Column(name = "CREATED_BY", updatable = false)
    @CreatedBy
    protected String createdBy;

    @Column(name = "CREATED_DATE", updatable = false)
    @CreatedDate
    protected LocalDateTime createdDate;

    @Column(name = "UPDATED_BY")
    @LastModifiedBy
    protected String lastModifiedBy;

    @Column(name = "UPDATED_DATE")
    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;

    @Version
    protected Integer version;

    @Column(name = "ACTIVE")
    protected Boolean active = Boolean.TRUE;
}
