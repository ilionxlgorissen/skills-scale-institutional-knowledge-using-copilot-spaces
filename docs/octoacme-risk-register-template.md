# OctoAcme — Risk Register Template

Use this template to track all known project risks. Maintain one Risk Register per project and review it at every weekly sync. The Risk Register is referenced by [`octoacme-risks-and-communication.md`](octoacme-risks-and-communication.md).

---

## Risk Register

| ID | Description | Category | Impact | Likelihood | Risk Score | Owner | Mitigation Plan | Contingency Plan | Status | Last Reviewed |
|----|-------------|----------|--------|------------|------------|-------|-----------------|------------------|--------|---------------|
| R-001 | _Example: Third-party API deprecation_ | Technical | High | Med | High | Developer Lead | Evaluate alternative APIs by sprint 3 | Revert to manual process if migration fails | Open | YYYY-MM-DD |
| R-002 | _Example: Key stakeholder unavailable during UAT_ | Resource | Med | Low | Low | PM | Pre-schedule UAT sessions; confirm availability 2 weeks ahead | Delay UAT by one sprint if needed | Open | YYYY-MM-DD |

_Add rows as new risks are identified. Archive resolved risks by setting Status to **Closed** rather than deleting rows._

---

## Field Definitions

| Field | Description |
|-------|-------------|
| **ID** | Unique identifier, e.g. R-001, R-002 |
| **Description** | Brief, plain-language description of the risk event |
| **Category** | One of: Technical, Resource, Schedule, Scope, External, Compliance |
| **Impact** | High / Med / Low — severity if the risk materialises |
| **Likelihood** | High / Med / Low — probability of occurrence |
| **Risk Score** | Combined rating: High-High = Critical; High-Med or Med-High = High; Med-Med = Med; otherwise Low |
| **Owner** | Named individual responsible for monitoring and mitigating the risk |
| **Mitigation Plan** | Actions taken to reduce impact or likelihood before the risk occurs |
| **Contingency Plan** | Actions to take if the risk does materialise |
| **Status** | Open / In Progress / Mitigated / Closed |
| **Last Reviewed** | Date the risk was last reviewed at a sync (YYYY-MM-DD) |

---

## Risk Score Matrix

|               | **High Impact** | **Med Impact** | **Low Impact** |
|---------------|-----------------|----------------|----------------|
| **High Likelihood** | 🔴 Critical | 🟠 High | 🟡 Med |
| **Med Likelihood**  | 🟠 High | 🟡 Med | 🟢 Low |
| **Low Likelihood**  | 🟡 Med | 🟢 Low | 🟢 Low |

---

## Usage Notes

- **Identify** risks continuously — not just during planning. Any team member can raise a new risk.
- **Review** the register at every weekly sync and mark items reviewed with the current date.
- **Escalate** Critical or High risks to the Project Manager immediately; see [escalation guidance](octoacme-risks-and-communication.md#escalation-paths).
- **Close** risks when they are fully mitigated or no longer relevant; do not delete rows.
- **Link** this register from the project README or status update so all stakeholders can access it.
