package readFile;

import javax.persistence.*;

@Entity
@Table(name = "TestDetail", schema = "LoiServerDatabase", catalog = "")
public class TestDetailEntity {
    private String testId;
    private String testDate;
    private String testMaterialId;
    private String testMaterialType;
    private String testIgniteType;
    private String testFinalLoi;
    private String testStepLength;
    private String testSigma;
    private String testSignOfKKs;
    private String testK;
    private String testKs;
    private String testDetail;
    private String testOperator;
    private String testRawDataFromLoi;

    @Id
    @Column(name = "Test_ID", nullable = false, length = 11)
    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "Test_date", nullable = true, length = 45)
    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    @Basic
    @Column(name = "Test_materialID", nullable = true, length = 45)
    public String getTestMaterialId() {
        return testMaterialId;
    }

    public void setTestMaterialId(String testMaterialId) {
        this.testMaterialId = testMaterialId;
    }

    @Basic
    @Column(name = "Test_materialType", nullable = true, length = 45)
    public String getTestMaterialType() {
        return testMaterialType;
    }

    public void setTestMaterialType(String testMaterialType) {
        this.testMaterialType = testMaterialType;
    }

    @Basic
    @Column(name = "Test_igniteType", nullable = true, length = 45)
    public String getTestIgniteType() {
        return testIgniteType;
    }

    public void setTestIgniteType(String testIgniteType) {
        this.testIgniteType = testIgniteType;
    }

    @Basic
    @Column(name = "Test_finalLOI", nullable = true, length = 45)
    public String getTestFinalLoi() {
        return testFinalLoi;
    }

    public void setTestFinalLoi(String testFinalLoi) {
        this.testFinalLoi = testFinalLoi;
    }

    @Basic
    @Column(name = "Test_stepLength", nullable = true, length = 45)
    public String getTestStepLength() {
        return testStepLength;
    }

    public void setTestStepLength(String testStepLength) {
        this.testStepLength = testStepLength;
    }

    @Basic
    @Column(name = "Test_sigma", nullable = true, length = 45)
    public String getTestSigma() {
        return testSigma;
    }

    public void setTestSigma(String testSigma) {
        this.testSigma = testSigma;
    }

    @Basic
    @Column(name = "Test_signOfKxks", nullable = true, length = 45)
    public String getTestSignOfKKs() {
        return testSignOfKKs;
    }

    public void setTestSignOfKKs(String testSignOfKKs) {
        this.testSignOfKKs = testSignOfKKs;
    }

    @Basic
    @Column(name = "Test_k", nullable = true, length = 45)
    public String getTestK() {
        return testK;
    }

    public void setTestK(String testK) {
        this.testK = testK;
    }

    @Basic
    @Column(name = "Test_ks", nullable = true, length = 45)
    public String getTestKs() {
        return testKs;
    }

    public void setTestKs(String testKs) {
        this.testKs = testKs;
    }

    @Basic
    @Column(name = "Test_detail", nullable = true, length = 250)
    public String getTestDetail() {
        return testDetail;
    }

    public void setTestDetail(String testDetail) {
        this.testDetail = testDetail;
    }

    @Basic
    @Column(name = "Test_operator", nullable = true, length = 45)
    public String getTestOperator() {
        return testOperator;
    }

    public void setTestOperator(String testOperator) {
        this.testOperator = testOperator;
    }

    @Basic
    @Column(name = "Test_rawDataFromLOI", nullable = true, length = 300)
    public String getTestRawDataFromLoi() {
        return testRawDataFromLoi;
    }

    public void setTestRawDataFromLoi(String testRawDataFromLoi) {
        this.testRawDataFromLoi = testRawDataFromLoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestDetailEntity that = (TestDetailEntity) o;

        if (testId != null ? !testId.equals(that.testId) : that.testId != null) return false;
        if (testDate != null ? !testDate.equals(that.testDate) : that.testDate != null) return false;
        if (testMaterialId != null ? !testMaterialId.equals(that.testMaterialId) : that.testMaterialId != null)
            return false;
        if (testMaterialType != null ? !testMaterialType.equals(that.testMaterialType) : that.testMaterialType != null)
            return false;
        if (testIgniteType != null ? !testIgniteType.equals(that.testIgniteType) : that.testIgniteType != null)
            return false;
        if (testFinalLoi != null ? !testFinalLoi.equals(that.testFinalLoi) : that.testFinalLoi != null) return false;
        if (testStepLength != null ? !testStepLength.equals(that.testStepLength) : that.testStepLength != null)
            return false;
        if (testSigma != null ? !testSigma.equals(that.testSigma) : that.testSigma != null) return false;
        if (testSignOfKKs != null ? !testSignOfKKs.equals(that.testSignOfKKs) : that.testSignOfKKs != null)
            return false;
        if (testK != null ? !testK.equals(that.testK) : that.testK != null) return false;
        if (testKs != null ? !testKs.equals(that.testKs) : that.testKs != null) return false;
        if (testDetail != null ? !testDetail.equals(that.testDetail) : that.testDetail != null) return false;
        if (testOperator != null ? !testOperator.equals(that.testOperator) : that.testOperator != null) return false;
        if (testRawDataFromLoi != null ? !testRawDataFromLoi.equals(that.testRawDataFromLoi) : that.testRawDataFromLoi != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId != null ? testId.hashCode() : 0;
        result = 31 * result + (testDate != null ? testDate.hashCode() : 0);
        result = 31 * result + (testMaterialId != null ? testMaterialId.hashCode() : 0);
        result = 31 * result + (testMaterialType != null ? testMaterialType.hashCode() : 0);
        result = 31 * result + (testIgniteType != null ? testIgniteType.hashCode() : 0);
        result = 31 * result + (testFinalLoi != null ? testFinalLoi.hashCode() : 0);
        result = 31 * result + (testStepLength != null ? testStepLength.hashCode() : 0);
        result = 31 * result + (testSigma != null ? testSigma.hashCode() : 0);
        result = 31 * result + (testSignOfKKs != null ? testSignOfKKs.hashCode() : 0);
        result = 31 * result + (testK != null ? testK.hashCode() : 0);
        result = 31 * result + (testKs != null ? testKs.hashCode() : 0);
        result = 31 * result + (testDetail != null ? testDetail.hashCode() : 0);
        result = 31 * result + (testOperator != null ? testOperator.hashCode() : 0);
        result = 31 * result + (testRawDataFromLoi != null ? testRawDataFromLoi.hashCode() : 0);
        return result;
    }
}
