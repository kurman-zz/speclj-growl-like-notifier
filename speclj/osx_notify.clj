(ns speclj.osx-notify
  (:use [clojure.java.shell :only [sh]]))

(deftype OsxNotifyReporter []
  speclj.reporting/Reporter
  (report-message [this message]
    (println) (flush))
  (report-description [this description])
  (report-pass [this result]
    (print ".") (flush))
  (report-pending [this result]
    (print "*") (flush))
  (report-fail [this result]
    (print  "F")
    (flush))
  (report-runs [this results]
    (let [failures (filter #(instance? speclj.results.FailResult %) results)]
      (if (not (empty? failures))
        (sh "terminal-notifier"
            "-title" "speclj autotest"
            "-subtitle" "Tests are failing"
            "-message" (str (count failures) " of " (count results)))
        )
      )
    (println)
    (flush)
    )) 

(defn new-osx-notify-reporter []
  (OsxNotifyReporter.))
