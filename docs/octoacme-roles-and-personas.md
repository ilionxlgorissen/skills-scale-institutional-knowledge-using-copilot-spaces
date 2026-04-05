# OctoAcme Personas

This document defines typical roles and responsibilities used in OctoAcme project docs and exercises.

---

## Developers

### Role Summary
Developers design, build, test, and deliver software components. They collaborate with product and project leads to implement features that meet acceptance criteria and quality standards.

### Responsibilities
- Implement features and fixes to meet acceptance criteria
- Write and maintain tests and documentation
- Participate in design and code reviews
- Assist in estimating and planning work
- Help identify technical risks and propose mitigations

### Goals
- Deliver reliable, maintainable code
- Reduce cycle time from idea to production
- Maintain high test coverage and observability

### Typical Communication
- Daily standups and sprint planning
- PR descriptions and code review comments
- Technical design docs when needed

### Works With
- **Product Manager (PdM):** Clarifies requirements and acceptance criteria; flags technical constraints.
- **Project Manager (PM):** Reports progress, surfaces blockers, and updates estimates.
- **Scrum Master:** Participates in agile ceremonies and raises impediments.
- **UX/UI Designer:** Reviews designs, provides feasibility feedback, and implements UI changes.
- **QA/Testing:** Collaborates on test coverage and resolves defects identified in review.
- **Release Manager:** Provides build artifacts, communicates deployment dependencies.

---

## Product Managers (PdM)

### Role Summary
Product Managers (PdMs) define what should be built to deliver customer and business value. They own the product vision, prioritize the backlog, and measure outcomes.

### Responsibilities
- Define problem statements and success metrics
- Prioritize the roadmap and backlog
- Collaborate with stakeholders and engineering on trade-offs
- Validate solutions through user research and metrics
- Write and maintain acceptance criteria for backlog items

### Goals
- Maximize customer value and impact
- Make clear, data-driven prioritization decisions
- Ensure product-market fit and usability

### Typical Communication
- Weekly alignment with PM and engineering leads
- Roadmap updates and stakeholder briefings
- Acceptance criteria and feature specs

### Works With
- **Project Manager (PM):** Aligns on timelines, scope changes, and risk decisions.
- **Business Analyst:** Reviews and refines requirements; resolves ambiguities before development starts.
- **UX/UI Designer:** Co-creates user flows, reviews prototypes, and validates usability.
- **Developers:** Answers questions on acceptance criteria and trade-offs during implementation.
- **Support Lead:** Reviews incoming feedback and bugs to inform backlog prioritization.

---

## Project Managers (PM)

### Role Summary
Project Managers (PMs) coordinate delivery activities, manage schedules, risks, and communications. They enable the team to deliver on commitments efficiently.

### Responsibilities
- Create and maintain project plans and timelines
- Manage risks, dependencies, and resource constraints
- Facilitate meetings (kickoff, planning, retrospectives)
- Ensure consistent project documentation and status reporting
- Coordinate cross-team and stakeholder communication

### Goals
- Deliver projects on time and within scope
- Minimize unplanned work and escalations
- Maintain transparency and alignment across stakeholders

### Typical Communication
- Weekly [Project Status Updates](octoacme-project-status-update-template.md) and stakeholder reports
- [Risk Register](octoacme-risk-register-template.md) and [Decision Log](octoacme-decision-log-template.md) maintenance
- Coordination via project boards and meeting facilitation

### Works With
- **Product Manager (PdM):** Weekly syncs on scope, priority changes, and milestone status.
- **Scrum Master:** Coordinates on sprint rhythms, impediments, and process compliance.
- **Release Manager:** Aligns on release windows, go/no-go decisions, and stakeholder announcements.
- **Business Analyst:** Reviews requirements documents and ensures they feed into the project plan.
- **Support Lead:** Receives post-release feedback and coordinates escalations.

---

## Scrum Master

### Role Summary
The Scrum Master facilitates agile ceremonies, coaches the team on process discipline, and removes impediments that block progress. They are a servant-leader who helps the team continuously improve how they work.

### Responsibilities
- Facilitate sprint ceremonies: planning, daily standups, sprint reviews, and retrospectives
- Identify and remove blockers and impediments that slow the team
- Coach team members on agile principles and OctoAcme process norms
- Shield the team from external distractions and scope creep during a sprint
- Track and report sprint velocity and team health metrics

### Goals
- Maximize team efficiency and flow
- Foster a culture of continuous improvement and psychological safety
- Ensure sprint ceremonies are focused, time-boxed, and actionable

### Typical Communication
- Daily standup facilitation and impediment escalation
- Sprint planning and retrospective meeting notes
- Process improvement proposals to the Project Manager

### Works With
- **Project Manager (PM):** Shares impediment status; escalates blockers that require cross-team coordination or stakeholder decisions.
- **Product Manager (PdM):** Coordinates backlog readiness for upcoming sprints; ensures items meet the Definition of Ready before planning.
- **Developers:** Coaches on agile practices; facilitates estimation and self-organization.
- **QA/Testing:** Ensures testing activities are integrated into sprint flow rather than left to the end.

---

## Business Analyst

### Role Summary
The Business Analyst (BA) bridges the gap between business stakeholders and the delivery team. They gather, analyze, and document requirements, ensuring that development work solves the right problems.

### Responsibilities
- Elicit requirements from stakeholders through interviews, workshops, and document review
- Translate business needs into clear, actionable user stories and acceptance criteria
- Maintain requirements traceability between stakeholder needs and backlog items
- Support backlog refinement by reviewing and improving story quality before sprint planning
- Identify gaps and ambiguities in requirements and resolve them with the Product Manager

### Goals
- Ensure requirements are complete, unambiguous, and testable before work begins
- Reduce rework caused by poorly defined requirements
- Provide a shared understanding of scope and expected outcomes across the team

### Typical Communication
- Requirements workshops and stakeholder interviews
- User story documentation and acceptance criteria writing
- Backlog refinement sessions with the Product Manager and development team

### Works With
- **Product Manager (PdM):** Works as an extension of the PdM to deepen requirements analysis and backlog quality.
- **Project Manager (PM):** Provides requirements status updates that feed into project planning and risk tracking.
- **Developers:** Answers questions, clarifies edge cases, and validates that implementations match intent.
- **UX/UI Designer:** Collaborates on user flows and ensures design solutions trace back to business requirements.
- **Scrum Master:** Partners to ensure backlog items meet a Definition of Ready before sprint planning.
- **QA/Testing:** Provides acceptance criteria as the basis for test cases.

---

## UX/UI Designer

### Role Summary
The UX/UI Designer creates user-centred designs that are both usable and accessible. They translate product requirements into wireframes, prototypes, and final design specs that guide implementation.

### Responsibilities
- Conduct user research, usability testing, and accessibility reviews
- Create wireframes, prototypes, and high-fidelity design specifications
- Maintain a consistent design system and component library
- Collaborate with developers to ensure accurate and feasible implementation of designs
- Incorporate feedback from users, stakeholders, and product reviews iteratively

### Goals
- Deliver intuitive, accessible, and visually consistent user experiences
- Reduce development rework by providing clear, implementation-ready designs
- Ensure all released features meet usability and accessibility standards

### Typical Communication
- Design reviews and prototype walkthroughs with Product Manager and stakeholders
- Design handoff documents and annotated specs shared with Developers
- Usability testing reports and design iteration notes

### Works With
- **Product Manager (PdM):** Aligns designs with product vision and user needs; participates in roadmap discussions.
- **Business Analyst:** Reviews requirements and translates them into user flows and interface concepts.
- **Developers:** Provides design specs; answers questions on design intent; reviews implemented UI for fidelity.
- **Scrum Master:** Ensures design work is planned within sprints and flagged if designs are not ready ahead of development.
- **QA/Testing:** Provides acceptance criteria for visual and interaction quality; reviews accessibility test results.

---

## Release Manager

### Role Summary
The Release Manager owns the end-to-end release process, ensuring that deployments are planned, coordinated, and communicated effectively. They act as the go/no-go decision point for production releases.

### Responsibilities
- Plan and schedule release windows in coordination with engineering and operations
- Verify that all pre-release requirements are met (see [Release Readiness Checklist](octoacme-release-readiness-checklist.md))
- Coordinate deployment activities across development, QA, and infrastructure teams
- Prepare and distribute release notes and stakeholder announcements
- Own the rollback plan and trigger incident response if a deployment fails
- Maintain a record of release decisions in the [Decision Log](octoacme-decision-log-template.md)

### Goals
- Ensure every production release is safe, well-communicated, and recoverable
- Minimize release-related incidents and unplanned rollbacks
- Provide stakeholders with timely, accurate release information

### Typical Communication
- Release calendar and go/no-go communications
- Deployment announcements and release notes to stakeholders and support
- Post-release verification reports

### Works With
- **Project Manager (PM):** Aligns release windows with project milestones and communicates schedule changes.
- **Developers:** Reviews release artifacts and deployment runbooks; confirms build readiness.
- **QA/Testing:** Confirms acceptance criteria and smoke tests are passed before go/no-go.
- **Support Lead:** Briefs support on upcoming changes; ensures handoff materials are prepared.
- **Product Manager (PdM):** Confirms feature completeness and customer communication is aligned with the release.

---

## Support Lead

### Role Summary
The Support Lead manages post-release customer support, owns the issue triage process, and feeds user insights back into the product and development teams to drive continuous improvement.

### Responsibilities
- Oversee the customer support queue and ensure support SLAs are met
- Triage incoming issues and escalate critical defects to engineering
- Document recurring issues and patterns to inform the product backlog
- Coordinate with the Release Manager on release communications and known-issue advisories
- Provide handoff materials and training to the support team for new features

### Goals
- Deliver a high-quality post-release support experience for customers
- Reduce mean time to resolution (MTTR) for reported issues
- Surface actionable product and quality insights from support data

### Typical Communication
- Incident and escalation reports to engineering and the Project Manager
- Support handoff notes received from the Release Manager at release time
- Regular feedback summaries shared with the Product Manager

### Works With
- **Release Manager:** Receives release briefings and known-issue advisories; confirms support readiness before go-live.
- **Product Manager (PdM):** Shares patterns from support data to inform backlog prioritization.
- **Developers:** Escalates critical production defects and provides reproduction steps.
- **Project Manager (PM):** Reports on outstanding support escalations that may affect project status.
- **QA/Testing:** Shares customer-reported defects that were missed before release to improve future test coverage.

---

## How these personas are used in the exercise
- Use these persona definitions to frame scenarios and sample interactions in the Skills Exercise.
- Each persona can be used as a persona prompt for Copilot Spaces to shape role-specific guidance.
- When referencing roles across documents, use **PM** for Project Manager and **PdM** for Product Manager consistently.

