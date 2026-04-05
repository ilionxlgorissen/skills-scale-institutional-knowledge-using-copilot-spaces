# OctoAcme — Release Readiness Checklist

Use this checklist before every production release to confirm that all required conditions are met. The checklist is owned by the **Release Manager** and must be reviewed in a go/no-go meeting with the PM, PdM, and QA leads. It complements the [`octoacme-release-and-deployment.md`](octoacme-release-and-deployment.md) guide.

Record the outcome (Go / No-Go) and any deferred items in the [Decision Log](octoacme-decision-log-template.md).

---

## Release Details

| Field | Value |
|-------|-------|
| **Release name / version** | |
| **Release type** | Patch / Minor / Major |
| **Planned release date** | YYYY-MM-DD |
| **Release Manager** | |
| **Go / No-Go decision** | |
| **Decision date** | YYYY-MM-DD |

---

## 1. Code & Quality

- [ ] All planned features and fixes are merged to the release branch
- [ ] All acceptance criteria for in-scope items have been verified (by QA or PdM)
- [ ] The Definition of Done (DoD) has been met for every item in scope
- [ ] No open blocking (P0/P1) defects; known issues are documented in release notes
- [ ] Code has been reviewed and approved (at least one approval per PR)
- [ ] CI pipeline is passing: unit tests, integration tests, linting, and security scans
- [ ] End-to-end smoke tests have been run and passed in the staging environment

## 2. Security & Compliance

- [ ] Security scan results reviewed; no critical or high vulnerabilities unaddressed
- [ ] Dependency vulnerability check completed (e.g., Dependabot alerts reviewed)
- [ ] Any required compliance or regulatory sign-offs obtained
- [ ] Secrets and credentials are not hardcoded; environment variables are correctly configured

## 3. Infrastructure & Environments

- [ ] Staging environment successfully deployed and smoke tested
- [ ] Production environment configuration reviewed (environment variables, feature flags)
- [ ] Database migrations tested in staging; rollback migration script prepared if needed
- [ ] Deployment window scheduled with operations/platform team (if required)
- [ ] Monitoring and alerting confirmed as operational for the release

## 4. Documentation & Communication

- [ ] Release notes drafted, reviewed, and approved
- [ ] Internal team notified of release schedule
- [ ] Customer-facing communication prepared (if applicable)
- [ ] Support Lead briefed on new features, known issues, and escalation contacts
- [ ] User-facing documentation or in-app help updated (if applicable)

## 5. Rollback & Incident Readiness

- [ ] Rollback plan documented and tested (or validated against last known-good release)
- [ ] On-call engineer confirmed and briefed on the release
- [ ] Incident escalation path reviewed (see [Escalation Paths](octoacme-risks-and-communication.md#escalation-paths))
- [ ] Post-deploy verification steps documented and assigned

---

## Go / No-Go Decision

| Attendee | Role | Go / No-Go | Notes |
|----------|------|------------|-------|
| | Release Manager | | |
| | Project Manager (PM) | | |
| | Product Manager (PdM) | | |
| | QA Lead | | |
| | Support Lead | | |

**Final decision:** `Go` / `No-Go`

**Deferred items (if No-Go or conditional Go):**

| Item | Owner | Target Date |
|------|-------|-------------|
| | | |

---

## Post-Release Verification

After deployment, confirm:

- [ ] Application is accessible and core flows are functional
- [ ] Monitoring dashboards show normal error rates and latency
- [ ] Release announcement sent to stakeholders and support
- [ ] Any deferred items logged in the [Decision Log](octoacme-decision-log-template.md) and tracked
- [ ] Post-release retrospective scheduled (if major release or incident occurred)
