package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Nominee.
 */
@Entity
@Table(name = "nominee")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Nominee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "nominee")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Choice> choices = new HashSet<>();
    @OneToMany(mappedBy = "id")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Category> ids = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Nominee name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    public Nominee choices(Set<Choice> choices) {
        this.choices = choices;
        return this;
    }

    public Nominee addChoice(Choice choice) {
        this.choices.add(choice);
        choice.setNominee(this);
        return this;
    }

    public Nominee removeChoice(Choice choice) {
        this.choices.remove(choice);
        choice.setNominee(null);
        return this;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }

    public Set<Category> getIds() {
        return ids;
    }

    public Nominee ids(Set<Category> categories) {
        this.ids = categories;
        return this;
    }

    public Nominee addId(Category category) {
        this.ids.add(category);
        category.setId(this);
        return this;
    }

    public Nominee removeId(Category category) {
        this.ids.remove(category);
        category.setId(null);
        return this;
    }

    public void setIds(Set<Category> categories) {
        this.ids = categories;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Nominee nominee = (Nominee) o;
        if (nominee.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), nominee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Nominee{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}