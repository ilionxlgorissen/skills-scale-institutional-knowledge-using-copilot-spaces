# OctoAcme — Risk Management & Communication

## Purpose
Explain how to identify, manage, and communicate risks and dependencies across OctoAcme projects. This document covers the risk lifecycle, stakeholder communication cadence, escalation paths, and links to supporting templates.

---

## Risk Register

Every project must maintain a Risk Register as its single source of truth for known risks. Use the **[Risk Register Template](octoacme-risk-register-template.md)** to create and maintain your register.

The register tracks:
- **ID** — unique identifier (e.g. R-001)
- **Description** — plain-language description of the risk
- **Category** — Technical, Resource, Schedule, Scope, External, or Compliance
- **Impact** — High / Med / Low
- **Likelihood** — High / Med / Low
- **Risk Score** — combined severity rating
- **Owner** — named individual responsible for monitoring and mitigating
- **Mitigation Plan** — actions taken to reduce impact or likelihood
- **Contingency Plan** — actions to take if the risk materialises
- **Status** — Open / In Progress / Mitigated / Closed
- **Last Reviewed** — date last reviewed at a sync

See the [Risk Register Template](octoacme-risk-register-template.md) for the full table format, field definitions, and a risk score matrix.

---

## Risk Lifecycle

1. **Identify:** Raise risks continuously — during planning, execution, and reviews. Any team member can add a risk.
2. **Assess:** Estimate impact and likelihood to produce a risk score (Critical / High / Med / Low).
3. **Mitigate:** Assign an owner and agree on mitigation actions and a contingency plan.
4. **Monitor:** Review all open risks at every weekly sync; update status and last-reviewed date.
5. **Close:** Mark risks as **Mitigated** or **Closed** when resolved; do not delete rows.

---

## Stakeholder Communication

### Stakeholder Mapping
At project start, identify stakeholder groups and their communication needs:

| Stakeholder Group | Interest | Communication Format | Frequency |
|-------------------|----------|----------------------|-----------|
| Engineering team | Progress, blockers, technical decisions | Standup, sprint review | Daily / per sprint |
| Product Manager (PdM) | Scope, priorities, customer impact | 1:1 sync, backlog review | Weekly |
| Project Sponsor / Leadership | Status, risks, budget | [Project Status Update](octoacme-project-status-update-template.md) | Weekly or milestone-based |
| External stakeholders / customers | Release timing, impact, known issues | Release notes, announcements | Per release |
| Support team | New features, known issues, escalation contacts | Handoff brief from Release Manager | Per release |

### Status Updates
Provide regular [Project Status Updates](octoacme-project-status-update-template.md) on the agreed cadence (typically weekly). Each update should include:
- Overall status (🟢 On Track / 🟡 At Risk / 🔴 Off Track)
- Progress this period
- Next steps
- Active risks and blockers (summarised from the Risk Register)
- Decisions needed from stakeholders

Use a **single source of truth** (project README, status update doc, or dedicated project board) to avoid conflicting versions of project status.

### Communication Cadence
- **Daily:** Standup (delivery team) — blockers, progress, and dependencies
- **Weekly:** PM–PdM sync; project status update distributed to stakeholders
- **Per sprint:** Sprint review / demo for stakeholders; backlog refinement
- **Per release:** Release announcement and support handoff (see [Release & Deployment Guide](octoacme-release-and-deployment.md))
- **Monthly:** Broader stakeholder update (if project runs longer than one month)

---

## Incident Communication

When an incident occurs (production issue, security event, or critical blocker):

1. **Triage summary** — what happened, what is affected, severity level
2. **Actions being taken** — immediate steps and who owns them
3. **Expected timeline** — estimated time to resolution or next update
4. **Stakeholder notification** — notify the PM and relevant stakeholders within the agreed SLA
5. **Post-incident:** Schedule a blameless retrospective; capture learnings and preventive actions

---

## Escalation Paths

Escalate issues based on their impact and urgency:

| Level | Trigger | Escalate To | Expected Response |
|-------|---------|-------------|-------------------|
| **Team-level** | Blocker within the team's control | Scrum Master / Tech Lead | Same day |
| **PM escalation** | Cross-team dependency or schedule risk | Project Manager (PM) | Within 24 hours |
| **Product escalation** | Scope change, customer impact, or High/Critical risk | Product Manager (PdM) + PM | Within 24 hours |
| **Leadership / Sponsor** | Budget impact, strategic risk, or unresolved escalation | Product Lead / Sponsor | Within 48 hours |
| **Security incident** | Suspected breach, data exposure, or critical vulnerability | Security on-call (follow security incident runbook) | Immediately |

Log escalation decisions in the [Decision Log](octoacme-decision-log-template.md) and update the Risk Register accordingly.
