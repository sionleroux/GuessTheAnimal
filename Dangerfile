# Warn when there are merge commits in the diff
if git.commits.any? { |c| c.message =~ /^Merge branch 'master'/ }
  warn 'Please rebase to get rid of the merge commits in this PR'
end

# Linting
commit_lint.check
todoist.warn_for_todos
