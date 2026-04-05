# OctoAcme — Decision Log Template

Use this template to record significant project decisions. A Decision Log creates a transparent, searchable record of *what* was decided, *why*, and *by whom* — reducing repeated debates and supporting future onboarding.

Maintain one Decision Log per project and link it from the project README or status update. The Decision Log is referenced by [`octoacme-risks-and-communication.md`](octoacme-risks-and-communication.md) and used by the [Release Manager](octoacme-roles-and-personas.md#release-manager) to record go/no-go decisions.

---

## Decision Log

| ID | Date | Decision | Context / Problem | Options Considered | Decision Rationale | Made By | Status | Related Links |
|----|------|----------|-------------------|--------------------|--------------------|---------|--------|---------------|
| D-001 | YYYY-MM-DD | _Example: Use PostgreSQL over MongoDB_ | Need persistent relational data for reporting | PostgreSQL, MongoDB, SQLite | Best support for complex queries; team familiarity | PM + Tech Lead | Accepted | [ADR-001](#) |
| D-002 | YYYY-MM-DD | _Example: Delay v2.0 release by two weeks_ | QA identified 3 blocking defects in UAT | Release on schedule vs. delay | Releasing with known defects would damage customer trust | PM, PdM, Release Manager | Accepted | [Risk R-004](#) |

_Add a new row for each significant decision. Mark superseded decisions with Status = **Superseded** and link to the newer decision._

---

## Field Definitions

| Field | Description |
|-------|-------------|
| **ID** | Unique identifier, e.g. D-001, D-002 |
| **Date** | Date the decision was made (YYYY-MM-DD) |
| **Decision** | A one-sentence statement of the decision taken |
| **Context / Problem** | What situation or question prompted the decision |
| **Options Considered** | Brief list of the alternatives that were evaluated |
| **Decision Rationale** | Why this option was chosen over the alternatives |
| **Made By** | Named individuals or roles who made or approved the decision |
| **Status** | Proposed / Accepted / Superseded / Revoked |
| **Related Links** | Links to relevant issues, ADRs, risk items, or meeting notes |

---

## When to Log a Decision

Log a decision when:
- It affects project scope, timeline, budget, or architecture.
- It represents a significant trade-off between competing options.
- It is likely to be questioned or revisited by new team members.
- It is required as part of a go/no-go release gate.

You do **not** need to log routine day-to-day choices (e.g., variable naming, minor refactors).

---

## Usage Notes

- **Timely logging:** Record decisions as soon as they are made, not weeks later.
- **Neutrality:** State the rationale factually — avoid editorialising.
- **Superseding:** If a previous decision is reversed, mark the original as **Superseded** and create a new entry referencing it.
- **Visibility:** Link this log from the project README and include its location in the Project Status Update template.
