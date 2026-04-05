# OctoAcme — Release & Deployment Guide

## Purpose
Standardize how OctoAcme releases features to production to reduce risk and improve observability. This guide is complemented by the **[Release Readiness Checklist](octoacme-release-readiness-checklist.md)**, which must be completed before every production deployment.

## Release Types
- **Patch:** hotfixes addressing critical production issues
- **Minor:** incremental features and improvements
- **Major:** significant functionality or breaking changes

## Roles
- **Release Manager:** owns the release process; leads the go/no-go decision; see [Release Manager](octoacme-roles-and-personas.md#release-manager).
- **Project Manager (PM):** aligns release windows with project milestones.
- **Product Manager (PdM):** confirms feature completeness and customer communications.
- **QA Lead:** confirms acceptance criteria and smoke test results.
- **Support Lead:** confirms support readiness and receives handoff materials.

## Pre-release Requirements
Before initiating a release, confirm all items in the **[Release Readiness Checklist](octoacme-release-readiness-checklist.md)**. At a minimum:
- All acceptance criteria met and PRs merged
- Passing CI and security scans
- Release notes drafted and reviewed
- Rollback / mitigation plan documented
- Smoke tests prepared and passed in staging
- Support Lead briefed on new features and known issues

## Go / No-Go Decision
Hold a brief go/no-go review with the Release Manager, PM, PdM, and QA Lead before every production release. Record the outcome in the [Decision Log](octoacme-decision-log-template.md). If the release is a No-Go, document the blocking items and target resolution date.

## Deployment Checklist
- [ ] Release Readiness Checklist completed and Go decision recorded
- [ ] Deployment window scheduled (if needed)
- [ ] Backup or snapshot (if applicable)
- [ ] Deploy to staging and run smoke tests
- [ ] Deploy to production (automated pipeline preferred)
- [ ] Run post-deploy verifications
- [ ] Announce release to stakeholders and support

## Rollback & Incident Playbook
- If a deployment fails or causes a critical issue:
  - Trigger incident response and notify on-call
  - Rollback to last known-good release if necessary
  - Triage root cause and capture action items
  - Schedule a blameless retrospective for major incidents
  - Follow escalation paths in [Risks & Communication](octoacme-risks-and-communication.md#escalation-paths)

## Release Notes Template
- Release name / version:
- Release type: Patch / Minor / Major
- Date:
- Summary:
- Notable changes:
- Migration steps (if any):
- Known issues:
- Support contact:
