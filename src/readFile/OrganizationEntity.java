package readFile;

import javax.persistence.*;

@Entity
@Table(name = "Organization", schema = "LoiServerDatabase", catalog = "")
public class OrganizationEntity {
    private int organizationId;
    private String organizationName;
    private String organizationLoiTester;
    private byte organizationValidate;
    private String organizationComment;

    @Id
    @Column(name = "Organization_ID", nullable = false)
    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    @Basic
    @Column(name = "Organization_name", nullable = true, length = 40)
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Basic
    @Column(name = "Organization_LoiTester", nullable = false)
    public String getOrganizationLoiTester() {
        return organizationLoiTester;
    }

    public void setOrganizationLoiTester(String organizationLoiTester) {
        this.organizationLoiTester = organizationLoiTester;
    }

    @Basic
    @Column(name = "Organization_validate", nullable = false)
    public byte getOrganizationValidate() {
        return organizationValidate;
    }

    public void setOrganizationValidate(byte organizationValidate) {
        this.organizationValidate = organizationValidate;
    }

    @Basic
    @Column(name = "Organization_comment", nullable = true, length = 45)
    public String getOrganizationComment() {
        return organizationComment;
    }

    public void setOrganizationComment(String organizationComment) {
        this.organizationComment = organizationComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationEntity that = (OrganizationEntity) o;

        if (organizationId != that.organizationId) return false;
        if (organizationValidate != that.organizationValidate) return false;
        if (organizationName != null ? !organizationName.equals(that.organizationName) : that.organizationName != null)
            return false;
        if (organizationLoiTester != null ? !organizationLoiTester.equals(that.organizationLoiTester) : that.organizationLoiTester != null)
            return false;
        if (organizationComment != null ? !organizationComment.equals(that.organizationComment) : that.organizationComment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organizationId;
        result = 31 * result + (organizationName != null ? organizationName.hashCode() : 0);
        result = 31 * result + (organizationLoiTester != null ? organizationLoiTester.hashCode() : 0);
        result = 31 * result + (int) organizationValidate;
        result = 31 * result + (organizationComment != null ? organizationComment.hashCode() : 0);
        return result;
    }
}
